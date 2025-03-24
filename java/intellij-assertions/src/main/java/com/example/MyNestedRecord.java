package com.example;

import org.jetbrains.annotations.NotNull;

public class MyNestedRecord {

  public static class Problem {
    private final int myLine;
    private final int column;
    private final String code;
    private final String description;

    public Problem(int line, int column, @NotNull String code, @NotNull String description) {
      myLine = line; // aim: see what auto-appends 'this' during rename
      this.column = column;
      this.code = code;
      this.description = description;
    }

    public int getLine() {
      return myLine;
    }

    public int getColumn() {
      return column;
    }

    @NotNull
    public String getCode() {
      return code;
    }

    @NotNull
    public String getDescription() {
      return description;
    }
  }
}
