package inspections;

import org.jetbrains.annotations.Nullable;

public class SimplifyIfStatement {
    String method1(boolean value) {
        if (value == true) {
            return "baz";
        }
        return "baz";
    }

    String method2(boolean value) {
        if (value == Boolean.TRUE) { // 'value == Boolean.TRUE' can be simplified to 'value'
            return "bar";
        }
        return "baz";
    }

    String method3(boolean value) {
        if (value == Boolean.FALSE) { // 'value == Boolean.FALSE' can be simplified to '!value'
            return "bar";
        }
        return "baz";
    }


    String method4(boolean value) {
        if (Boolean.TRUE.equals(value)) { // 'value == Boolean.FALSE' can be simplified to '!value'
            return "bar";
        }
        return "baz";
    }

    String method5(boolean value) {
        if (java.lang.Boolean.TRUE.equals(value)) { // 'value == Boolean.FALSE' can be simplified to '!value'
            return "bar";
        }
        return "baz";
    }

    String method6() {
        if (Boolean.TRUE == returnsNullableBoolean()) {
            return "bar";
        }
        return "baz";
    }

    String method7(boolean value) {
        value = true;
        if (!value) {
            //comment
            return "bar";
        }
        return "baz";
    }

    String method8(boolean value) {
        if (Boolean.TRUE.equals(value)) {
            return ".foo";
        }
        return "baz";
    }

    String method9(boolean value) {
        if (true == value) {
            return "bar";
        }
        return "baz";
    }

    @Nullable Boolean returnsNullableBoolean() {
        if (Math.random() > 0.66) return true;
        if (Math.random() > 0.33) return false;
        return null;
    }

    String method10(Object foo) {
        if (foo instanceof String) {
            return ".foo is String";
        }
        return ".foo is not String";
    }
}


class BoxedSign1 {
    String method() {
        if (returnsBool() == Boolean.TRUE) {
            return ".foo";
        }
        return "baz";
    }

    public Boolean returnsBool() {
        return Math.random() > 0.5;
    }
}


class BoxedSign2 {
    String method() {
        if (returnsBool() == Boolean.TRUE) {
            return ".foo";
        }
        return "baz";
    }

    public @Nullable Boolean returnsBool() {
        return Math.random() > 0.5;
    }
}

class BoxedSign3Complex {
    String method() {
        if (returnsBool() == Boolean.TRUE || maybeReturnsBool() == Boolean.TRUE) {
            return ".foo";
        }
        return "baz";
    }

    public Boolean returnsBool() {
        return Math.random() > 0.5;
    }

    public @Nullable Boolean maybeReturnsBool() {
        return Math.random() > 0.5;
    }
}

class Boxed {
    String method(boolean value) {
        if (value == ((Boolean.TRUE))) {
            return ".foo";
        }
        return "baz";
    }
}


class BoxedCall1 {
    String method(boolean value) {
        if (Boolean.TRUE.equals(returnsBool(value))) {
            return ".foo";
        }
        return "baz";
    }

    public Boolean returnsBool(boolean value) {
        return Math.random() > 0.5;
    }
}


class BoxedCall2 {
    String method(boolean value) {
        if (Boolean.TRUE.equals(returnsBool(value))) {
            return ".foo";
        }
        return "baz";
    }

    public @Nullable Boolean returnsBool(boolean value) {
        return Math.random() > 0.5;
    }
}
