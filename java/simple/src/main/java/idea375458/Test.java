package idea375458;

import org.jetbrains.annotations.NotNullByDefault;
import org.jetbrains.annotations.Nullable;

import java.util.List;


@NotNullByDefault
class Test {
    private static void processList(List<Integer> list) {
        Integer result = list.stream()
                .map(x -> (@Nullable Integer) x) // unwanted 'redundant cast' warning
                .reduce(null, (a, b) -> a == null ? b : Math.max(a, b));
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("empty");
        }
    }

    public static void main(String[] args) {
        processList(List.of());
    }
}