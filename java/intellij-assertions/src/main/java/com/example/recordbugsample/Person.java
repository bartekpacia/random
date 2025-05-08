package com.example.recordbugsample;

import java.util.Objects;

class Person {
  private final String name;
  private final int age;

  Person(String myName, int myAge) {
    name = myName;
    age = myAge;
  }

  public void foo() {

  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return age == person.age && Objects.equals(name, person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }
}

