package com.example.recordbugsample;

import kotlin.jvm.JvmField;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
@interface Field {

}

class Main2 {
  @Field final int a;
  final int b;

  Main2(int a, int b) {
    this.a = 0;
    this.b = 0;
  }

  Main2(int a) {
    this.a = a;
    this.b = 0;
  }
}

class Person2 {
  final String lName;
  final String fName;
  final int age;

  Person2(String firstName, String lastName, int age) {
    this.fName = firstName + lastName;
    this.lName = lastName + firstName;
    this.age = age;
  }
}

/*class Main {
  @Field final int a;
  final int b;

  Main(int first, int second) {
    this.a = first + second;
    this.b = second + first;
  }
}*/

public class Main {
  public final int a;
  public final int b;

  public Main(int a, int b) {
    this.a = b;
    this.b = a;
  }
}
