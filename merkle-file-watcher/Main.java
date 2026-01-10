import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        // Workflow:
        //  1. Initial run of the program. Hash all files in $PWD and build initial tree for $PWD
        //  2. On key 'r'

        while (true) {
            try {
                int c = (char) System.in.read();
                try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Path.of("."))) {
                    for (Path path : directoryStream) {
                        if (!Files.isRegularFile(path)) continue;
                        if (!path.getFileName().toString().endsWith((".txt"))) {
                            continue;
                        }

                        MessageDigest md = MessageDigest.getInstance("SHA-256");
                        try (InputStream inputStream = Files.newInputStream(path)) {
                            byte[] buf = new byte[1024];
                            int bytesRead;
                            while ((bytesRead = inputStream.read(buf)) != -1) {
                                md.update(buf, 0, bytesRead);
                            }
                        }
                        byte[] digest = md.digest();

                        StringBuilder hex = new StringBuilder();
                        for (byte b : digest) {
                            hex.append(String.format("%02x", b));
                        }

                        System.out.println("--> file " + path.getFileName().toString() + ": " + hex);
                    }
                }
            } catch (IOException | NoSuchAlgorithmException e) {
                throw new RuntimeException("failed to read from stdin", e);
            }
        }
    }
}

class Node {
    byte[] hash;
    Node left;
    Node right;

    public Node(byte[] hash) {
        this.hash = hash;
    }
}