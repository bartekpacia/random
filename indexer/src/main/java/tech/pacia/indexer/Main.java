package tech.pacia.indexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("invalid arguments. Usage: ./indexer <command> <file> <word>");
            System.exit(1);
        }

        String command = args[0];

        Path path = Paths.get(args[1]);
        if (!Files.exists(path)) {
            System.err.println("file does not exist: " + path);
            System.exit(1);
        }

        // commands = search-dumb / build-index / search-index
        String searchWord = args[3].toLowerCase(Locale.ROOT);
        switch (command) {
            case "search-dumb": {

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
                break;
            }
            case "build-index": {
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
                } catch (IOException e) {
                    throw new RuntimeException("failed to read from " + path, e);
                }

                long duration = System.currentTimeMillis() - startMillis;
                System.out.println("built index (" + index.size() + " keys) in " + duration + " ms");

                List<Position> positions = index.get(searchWord);
                if (positions == null) {
                    System.out.println("no entry in index for key " + searchWord);
                    System.exit(0);
                }
                // System.out.println("result: " + positions);
                for (int i = 0; i < positions.size(); i++) {
                    Position position = positions.get(i);
                    System.out.println(position);
                }

                break;
            }
            case "search-index": {
                break;
            }
            default: {
                System.err.println("invalid command");
                System.exit(1);
            }
        }

    }
}

record Position(Path path, int line, int offset) {
    @Override
    public String toString() {
        return /*path + "@" +*/ line + ":" + offset;
    }
}
