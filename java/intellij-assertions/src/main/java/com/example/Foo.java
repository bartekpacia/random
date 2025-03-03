package com.example;

public class Foo {
  private final String data;

  Foo(String data) {
    this.data = data;
  }

  public boolean isValid() {
    return data.length() % 2 == 0;
  }

  // some other methods that make use of the encapsulated information, for example returning it in different formats

  private String blah(int foo) {
    String path1;
    String path2;

    switch (foo) {
      case 10:
        return "here";
      case 11:
        return "case";
    }

    switch (foo) {
      case 1 -> path1 = "bar";
      case 2 -> path2 = "Hello";
    }

    return switch (foo) {
      case 1 -> "here";
      case 2 -> "Hello";
      default -> "idk";
    };
  }
}
