package tech.pacia.indexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    /// Will be `/tmp/indexer.sock` on Unix/macOS.
    static final Path socketPath = Path.of(System.getProperty("java.io.tmpdir"), "indexer.sock");

    static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("invalid arguments. Usage: ./indexer <command> <file> <word>");
            System.exit(1);
        }

        String command = args[0];

        // commands = search-dumb / build-index / search-index
        switch (command) {
            case "search-dumb": {
                Path path = Paths.get(args[1]);
                if (!Files.exists(path)) {
                    System.err.println("file does not exist: " + path);
                    System.exit(1);
                }

                String searchWord = args[3].toLowerCase(Locale.ROOT);
                dumbSearch(path, searchWord);
                break;
            }
            case "build-index": {
                Path path = Paths.get(args[1]);
                if (!Files.exists(path)) {
                    System.err.println("file does not exist: " + path);
                    System.exit(1);
                }

                Map<String, List<Position>> index = buildIndex(path);
                startServer(index);
                break;
            }
            case "search-index": {
                String searchWord = args[1].toLowerCase(Locale.ROOT);
                query(searchWord);
                break;
            }
            default: {
                System.err.println("invalid command");
                System.exit(1);
            }
        }

    }

    private static void dumbSearch(Path path, String searchWord) {
        int lineNumber = 1;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            int occurrence = 1;
            while ((line = reader.readLine()) != null) {
                int offset = 0;
                while ((offset = line.toLowerCase(Locale.ROOT).indexOf(searchWord, offset)) != -1) {
                    offset++; // let's start from 1, not from 0
                    Position position = new Position(path, lineNumber, offset);
                    System.out.println(position);
                    //System.out.println("found occurrence " + occurrence + " in " + path + "@" + lineNumber + ":" + offset);
                    occurrence++;
                    offset++;
                }

                lineNumber++;
            }
        } catch (IOException e) {
            throw new RuntimeException("failed to read from " + path, e);
        }
    }

    private static Map<String, List<Position>> buildIndex(Path path) throws IOException {
        Map<String, List<Position>> index = new HashMap<>();
        Set<Character> ignored = Set.of(' ', '.', ',', ';', '“', '”', '\n');
        int lineNumber = 0;
        long startMillis = System.currentTimeMillis();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                int i = 0;
                int n = line.length();
                while (i < n) {
                    while (i < n && ignored.contains(line.charAt(i))) {
                        i++;
                    }
                    int start = i;
                    while (i < n && !ignored.contains(line.charAt(i))) {
                        i++;
                    }
                    if (start < i) {
                        String key = line.substring(start, i).toLowerCase();
                        Position position = new Position(path, lineNumber, start);
                        index.computeIfAbsent(key, (k) -> new ArrayList<>()).add(position);
                    }
                }

                lineNumber++;
            }
        }

        long duration = System.currentTimeMillis() - startMillis;
        System.out.println("built index (" + index.size() + " keys) in " + duration + " ms");

        return index;
    }

    private static void startServer(Map<String, List<Position>> index) throws IOException {
        // Delete stale socket file if exists
        Files.deleteIfExists(socketPath);

        UnixDomainSocketAddress address = UnixDomainSocketAddress.of(socketPath);
        try (ServerSocketChannel server = ServerSocketChannel.open(StandardProtocolFamily.UNIX)) {
            server.bind(address);
            System.out.println("server bound to " + address);

            while (true) {
                SocketChannel client = server.accept();
                // Read query, search index, write results

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                StringBuilder sb = new StringBuilder();
                while (client.read(buffer) > 0) {
                    buffer.flip();
                    sb.append(StandardCharsets.UTF_8.decode(buffer));
                    buffer.clear();
                    if (sb.toString().contains("\n")) {
                        break;
                    }
                }
                String searchWord = sb.toString().toLowerCase(Locale.ROOT).trim();
                System.out.println("--> got query: " + searchWord);

                List<Position> positions = index.get(searchWord);
                if (positions == null) {
                    System.out.println("no entry in index for key " + searchWord);
                } else {
                    int i = 0;
                    for (; i < positions.size(); i++) {
                        Position position = positions.get(i);
                        byte[] bytes = (position.toString() + '\n').getBytes(StandardCharsets.UTF_8);
                        client.write(ByteBuffer.wrap(bytes));
                    }
                    client.write(ByteBuffer.allocateDirect('\n'));
                    System.out.println("<-- wrote back the response (" + i + " results)");
                }
            }
        }
    }

    private static void query(String searchWord) throws IOException {
        UnixDomainSocketAddress address = UnixDomainSocketAddress.of(socketPath);
        try (SocketChannel channel = SocketChannel.open(address)) {
            String request = searchWord + "\n";

            byte[] bytes = request.getBytes(StandardCharsets.UTF_8);
            channel.write(ByteBuffer.wrap(bytes));

            // Read response until empty line
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            StringBuilder response = new StringBuilder();

            while (channel.read(buffer) > 0) {
                buffer.flip();
                response.append(StandardCharsets.UTF_8.decode(buffer));
                buffer.clear();

                // Check for the end of response (empty line = "\n\n")
                if (response.toString().endsWith("\n\n")) break;
            }

            // Print results (trim trailing empty line)
            System.out.print(response.toString().stripTrailing());
        }
    }
}


record Position(Path path, int line, int offset) {
    @Override
    public String toString() {
        return /*path + "@" +*/ line + ":" + offset;
    }
}
