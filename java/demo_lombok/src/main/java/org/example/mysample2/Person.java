package org.example.mysample2;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

public class Person {
    public static void main(String[] args) {
        Person3 person3 = new Person3("John");
        System.out.println("person3 = " + person3);
    }
}

@AllArgsConstructor
class Person1 {
    final String name;
    final int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

@ToString
@EqualsAndHashCode
class Person2 {
    String name;
    int age;

    @Override
    public String toString() {
        return "Person2{name='" + name + "', age=" + age + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return age == person2.age && Objects.equals(name, person2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

@ToString
class Person3 {
    final String name;
    final int age;

    public Person3(String name) {
        this.name = name;
        this.age = 42;
    }

    public Person3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

@AllArgsConstructor
record Person4(String name, int age) {
}

@Value
record Person5(String name, int age) {
}
