package com.example;

public class RecordWithEnum {

  private final Mode mode;
  private final String name;
  private final Nested nested;
  private final java.util.List<Integer> integers;
  private final java.util.Set<java.lang.String> strings;

  public RecordWithEnum(Mode mode, String name, Nested nested, java.util.List<Integer> integers, java.util.Set<java.lang.String> strings) {
    this.mode = mode;
    this.name = name;
    this.nested = nested;
    this.integers = integers;
    this.strings = strings;
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

  public java.util.List<Integer> getIntegers() {
    return integers;
  }

  public java.util.Set<java.lang.String> getStrings() {
    return strings;
  }

  public enum Mode {
    Add, Sub
  }

  public static class Nested {
    int i;
  }
}
