import java.util.concurrent.StructuredTaskScope;

public class Main {
    public static void main(String[] args) {
        StableValue.of("foo");
        try (var scope = StructuredTaskScope.open()) {
            scope.fork(() -> System.out.println("ok"));
        }
    }
}

