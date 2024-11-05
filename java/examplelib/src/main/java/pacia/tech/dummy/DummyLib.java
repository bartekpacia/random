package pacia.tech.dummy;

import org.jetbrains.annotations.NotNull;

public class DummyLib {
    private static int a = 1;

    public static void main(String[] args) {
        String result = foo(null);
        assert 1 + a == 2;
        System.out.println("hello, comparison result: " + result);
    }

    public static @NotNull String foo(@NotNull String bar) {
        int a = 2 + 3;
        return bar.concat("end");
    }
}
