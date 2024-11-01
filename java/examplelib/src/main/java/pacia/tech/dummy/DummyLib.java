package pacia.tech.dummy;

import org.jetbrains.annotations.NotNull;

public class DummyLib {
    public static void main(String[] args) {
        String result = foo(null);
        System.out.println("hello, comparison result: " + result);
    }

    public static @NotNull String foo(@NotNull String bar) {
        boolean result = bar.equals("baz");
        return "blah " + bar;
    }

    public enum ExampleNestedEnum {RED, GREEN, BLUE}
}
