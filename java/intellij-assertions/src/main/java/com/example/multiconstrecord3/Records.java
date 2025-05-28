package com.example.multiconstrecord3;

class Record1 {
  final String name;
  final int age;

  Record1(String name, int age) {
    this.name = name;
    this.age = age;
  }
}

class Record2 {
  final String name;
  private final int age;

  Record2(String name, int age) {
    this.name = name;
    this.age = age;
  }
}

record Class1(String name, int age) {
}

record Class2(String name, int age) {
}
