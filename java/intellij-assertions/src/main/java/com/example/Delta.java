package com.example;

import org.jetbrains.annotations.NotNull;

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

class ProblemOK {
  public final int myLine;
  public final int myColumn;
  public final @NotNull String code;

  public ProblemOK(int line, int column, @NotNull String code) {
    myLine = line;
    myColumn = column;
    this.code = code;
  }
}
