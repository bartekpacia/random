package com.example;

public class RecordWithEnum {

  private final Mode mode;
  private final String name;
  private final Nested nested;

  public RecordWithEnum(Mode mode, String name, Nested nested) {
    this.mode = mode;
    this.name = name;
    this.nested = nested;
  }

  public Mode getMode() {
    return mode;
  }

  public String getName() {
    return name;
  }

  public Nested getNested() {
    return nested;
  }

  public enum Mode {
    Add, Sub
  }

  public static class Nested {
    int i;
  }
}
