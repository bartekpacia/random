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

  String method99(boolean value) {
    if (Boolean.TRUE.equals(value)) {
      return "foo";
    }
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
}
