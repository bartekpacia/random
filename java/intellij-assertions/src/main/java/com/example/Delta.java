package com.example;

import org.jetbrains.annotations.NotNull;

record R0(int myFirst, int mySecond) {
}

record R21(int myFirst, int mySecond) {
}

final class R20 {
  final int first;
  final String second;
  final int[] third;

  private R20(int first, String second, int... third) {
    this.first = first;
    this.second = second;
    this.third = third;
  }

  private int first() {
    return first > 0 ? first : -first;
  }

  // In preview for this: I expect to see 'getSecond' being renamed to 'second'
  String getSecond() {
    return second.length() > 1 ? second : "";
  }

  private int[] getThird() {
    return third;
  }
}

record R4(int x, int y) {
}

record R1(int myFirst, int mySecond) {
}

record R2(int myFirst, int mySecond, int myThird) {
  R2(int myFirst, int mySecond, int myThird) {
    this.myFirst = myFirst;
    this.mySecond = mySecond;
    this.myThird = idk; // unresolved symbol, but we still can convert
  }
}

class Problem {
  public final int myLine;
  public final @NotNull String code;
  public final int myColumn;

  public Problem(int line, int myColumn, @NotNull String code) {
    myLine = line;
    this.myColumn = myColumn;
    this.code = code;
  }
}

record ProblemOK(int myLine, int myColumn, @NotNull String code) {
}

public class Delta {
  public static void main(String[] args) {
    ProblemOK problemOK = new ProblemOK(21, 37, "lol");
    System.out.println("line: " + problemOK.myLine() + ", column: " + problemOK.myColumn());
  }
}

