package com.example;

public final class RecordDemo {
  private static final RecordDemo INSTANCE = new RecordDemo(new Object());

  private final Object someObject;

  private RecordDemo(Object someObject) {
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
