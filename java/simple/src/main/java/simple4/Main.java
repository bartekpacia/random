package simple4;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}

class BooleanStringTernaryParen {
    void foo(boolean param) {
        String output1 = param ? "true" : "false";
        String output2 = param ? "false" : "true";
    }

    void foo(Boolean param) {
        String output1 = param ? ("true") : "false";
        String output2 = ((param)) ? ("true") : "false";
    }

    public String foo2(Boolean value) {
        return value ? "true" : "false";
    }
}