package com.example;

class NamedConstants {
  private static final int ALPHA = 0;
  private static final int BRAVO = 0;
  private static final int FOO = 9;
  private static final int BAR = 9;

  public static final int ONE = 1;

  public static void main(String[] args) {
    int i = FOO + BAR;
    int j = ALPHA + BRAVO;
    int k = ALPHA + BRAVO + FOO;
    int l = FOO - BAR;
    int n = FOO - BAR + Integer.parseInt(args[0]);

    final int one = 1;

    int ads = Integer.parseInt(args[0]) * one; // no highlight

    // int m = <warning descr="'BRUH + BRUH' can be replaced with '0'">BRUH + BRUH</warning>;
    int x = ((ALPHA)) + ALPHA;
    int y= ((FOO)) * (ONE);
  }
}
