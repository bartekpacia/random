package com.example;

import org.jetbrains.annotations.NotNull;

class R0 {
  final int myFirst;
  final int mySecond;

  R0(int first, int nothing) {
    myFirst = first;
    mySecond = nothing;
  }
}

class R4 {
  final int x;
  final int y;

  R4(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class R1 {
  final int myFirst;
  final int mySecond;

  R1(int first, int nothing) {
    myFirst = first;
    mySecond = nothing;
  }
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

