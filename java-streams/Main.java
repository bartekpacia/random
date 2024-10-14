import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Stream<String> stream = Stream.of("Hello", "World");
        var result = stream
                .map((str) -> {
                    System.out.println("converting string: " + str);
                    return str.toUpperCase();
                })
                .findFirst()
                .get();

        System.out.println(result);
    }
}
