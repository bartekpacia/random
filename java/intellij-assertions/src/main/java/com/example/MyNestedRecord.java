package com.example;

import org.jetbrains.annotations.NotNull;

class SomeClass {
  public static class Problem {
    private final int line;
    private final int column;
    private final String code;
    private final String description;

    public Problem(int line, int column, @NotNull String code, @NotNull String description) {
      this.line = line;
      this.column = column;
      this.code = code;
      this.description = description;
    }

    public int getLine() {
      return line;
    }

    public int getColumn() {
      return column;
    }

    public @NotNull String code() {
      return code;
    }

    public @NotNull String description() {
      return description;
    }
  }
}
