package com.example.multiconstrecord;

class Person {
  final String name;
  final int age;

  Person(String name, int age) {
    this.name = name;
    this.age = age;
    System.out.println("xd");
  }
}

class PersonMulti {
  final String name;
  final int age;

  PersonMulti(String name, int age) {
    this.name = name;
    this.age = age;
  }

  PersonMulti(String name) {
    this.name = name;
    this.age = 42;
  }

  PersonMulti(int age) {
    this("Unknown", age);
  }
}

record PersonMultiRecord(String name, int age) {
  PersonMultiRecord(String name) {
    this(name, 42);
    System.out.println("Name custom, age default");
  }

  PersonMultiRecord(int age) {
    this("Unknown", age);
    System.out.println("Name default, age custom");
  }
}

record Point(double x, double y) {
  Point(double x, double y) {
    this.x = x;
    System.out.println("Hello I was just created");
    this.y = y;
  }
}


record PersonMulti2(String name, int age) {
  PersonMulti2(String name) {
    this(name, 42);
  }

  PersonMulti2(int age) {
    this("Unknown", age);
  }
}

class NonCanonicalClass {
  final String name;
  final int age;

  public NonCanonicalClass(String name) {
    this.name = name;
    this.age = 42;
  }
}

record NonCanonicalRecord(String name, int age) {

  // During conversion to record, this constructor will become a canonical constructor, and then be removed because it's redundant.
  // Removal of a redundant canonical constructor is actually an inspection on its own: RedundantRecordConstructorInspection
  NonCanonicalRecord(String name, int age) {
    this.name = name;
    this.age = age;
  }
}


record MyAnotherRecord(String name, int age) {
  MyAnotherRecord {
    name = "xd";
    age = 10;
  }

  MyAnotherRecord(String name, int age, int foo) {
    this(name, age);
  }

  MyAnotherRecord(String name) {
    this(name, 2137, 10);
  }
}


