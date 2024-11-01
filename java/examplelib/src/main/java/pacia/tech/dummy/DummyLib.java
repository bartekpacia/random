package pacia.tech.dummy;

import org.jetbrains.annotations.NotNull;

/// Showcases differences between 3 decompiler presets:
/// 1. Diff high-Medium: default constructor visibility
/// 2. Diff medium-low: decompile assertions, decompile intellij annotation, decompile enums
public class DummyLib {
    private static int a = 1;

    public static void main(String[] args) {
        String result = foo(null);
        assert 1 + a == 2;
        System.out.println("hello, comparison result: " + result);
    }

    public static @NotNull String foo(@NotNull String bar) {
        boolean result = bar.equals("baz");
        return "blah " + bar;
    }
}
