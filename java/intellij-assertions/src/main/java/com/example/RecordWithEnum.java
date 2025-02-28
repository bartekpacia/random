package com.example;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public record RecordWithEnum(com.example.RecordWithEnum.Mode mode, String name,
                             com.example.RecordWithEnum.Nested nested, List<Integer> integers, Set<String> strings) {

  @Override
  public String toString() {
    return "RecordWithEnum[" +
      "mode=" + mode + ", " +
      "name=" + name + ", " +
      "nested=" + nested + ", " +
      "integers=" + integers + ", " +
      "strings=" + strings + ']';
  }


  public enum Mode {
    Add, Sub
  }

  public static class Nested {
    int i;
  }
}
