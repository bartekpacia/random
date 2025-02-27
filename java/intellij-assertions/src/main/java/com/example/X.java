package com.example;

class A {
  private final int field;

  public A(int field) {
    this.field = field;
  }

  public static int field() {
    return 1;
  }
}

class B {
  private final int field;

  B(int field) {
    this.field = field;
  }

  public static int getField() {
    return 1;
  }
}

class C {
  private final boolean field;

  C(boolean field) {
    this.field = field;
  }

  public static boolean isField() {
    return true;
  }
}
