package com.example;

class NamedConstants {
  private static final int FOO = 9;
  private static final int BAR = 9;
  private static final int MINUS_NINE = -9;

  private final int BAZ = 9;
  private final int QUX = 9;
  private final int QUUX = 0;
  private static final int ZERO_CONSTANT = 0;
  private static final int ONE_CONSTANT = 1;
  private static final int TWO_CONSTANT = 2;

  public void foo(String[] args) {
    int a = -FOO + BAR;
    int b = FOO - BAR;

    int c = Integer.parseInt(args[0]);

    int i = -FOO + BAR + Integer.parseInt(args[0]);
    int j = Integer.parseInt(args[0]);
    int jj = Integer.parseInt(args[0]);
    int jjj = FOO - 8 + Integer.parseInt(args[0]);

    int j1 = FOO + Integer.parseInt(args[0]);
    int j2 = FOO * TWO_CONSTANT + Integer.parseInt(args[0]);

    int k = QUUX + Integer.parseInt(args[0]);

    int l = ONE_CONSTANT + Integer.parseInt(args[0]);
    int m = Integer.parseInt(args[0]);
    int n = QUUX + QUUX;

    int z = (1 + 1) * Integer.parseInt(args[0]);
  }

  public void subtract(int someVar) {
    int a1 = someVar;
    int a2 = someVar;
    int a3 = ((someVar));
    int a4 = someVar;
    int b2 = -someVar;
    int b3 = MINUS_NINE - someVar;
    int b = someVar - ONE_CONSTANT;
    int c = someVar - ONE_CONSTANT - TWO_CONSTANT;
    int c1 = someVar - ONE_CONSTANT - TWO_CONSTANT + someVar;
    int e = ZERO_CONSTANT;
    int f = ((ZERO_CONSTANT));

    final int localZero = 0;
    int g = localZero;
  }

  public void add(int someVar) {
    int a1 = someVar;
    int a2 = someVar;
    int b = ((someVar));
    int c = someVar + ONE_CONSTANT;
    int d = someVar + ONE_CONSTANT + TWO_CONSTANT;
    int e = 0;
    int f = 0;
    int g = ONE_CONSTANT + ONE_CONSTANT;

    final int localZero = 0;
    int h = 0;
  }

  public void multiply(int someVar) {
    int a = someVar;
    int b = ((someVar));
    int c = someVar * someVar;
    int d = someVar * someVar * someVar;
    int e = someVar * someVar * someVar * TWO_CONSTANT;

    final int localZero = 0;
    final int localOne = 1;
    int x = 0;
    int y = someVar;
  }

  public void divide(int someVar) {
    int a = ONE_CONSTANT;
    int b = someVar;
    int c = someVar / TWO_CONSTANT;
    int d = 42 / TWO_CONSTANT;
    int e = TWO_CONSTANT / someVar;
    int f = someVar;
  }
}
