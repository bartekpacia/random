package com.example;

import org.jetbrains.annotations.NotNull;

public final class RecordDemo {
  private static final RecordDemo INSTANCE = new RecordDemo(new Object());

  private final Object someObject;

  private RecordDemo(@NotNull Object someObject) {
    this.someObject = someObject;
  }

  public static RecordDemo getInstance() {
    return INSTANCE;
  }

  public Object getSomeObject() {
    return someObject;
  }
}

class Person {
  final Object someObject;

  Person(Object someObject) {
    this.someObject = someObject;
  }
}

class SomeClassX {
  public static class Problem {
    private final int myLine;
    private final int myColumn;
    private final @NotNull String myCode;
    private final @NotNull String description;

    public Problem(int line, int myColumn, @NotNull String code, @NotNull String description) {
      myLine = line;
      this.myColumn = myColumn;
      myCode = code;
      this.description = description;
    }
  }
}
