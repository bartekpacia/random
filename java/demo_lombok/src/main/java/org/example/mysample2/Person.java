package org.example.mysample2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.Value;

import java.util.Objects;

public class Person {
    public static void main(String[] args) {
        Person3 person3 = new Person3("John");
        System.out.println("person3 = " + person3);
    }
}

@NoArgsConstructor
class Person_A {
    String name;
    int age;

    Person_A() {}
}

@RequiredArgsConstructor
class Person_B {
    final String name;
    int age;

    public Person_B(String name) {
        this.name = name;
    }
}

@AllArgsConstructor
class Person_C {
    String name;
    int age;

    public Person_C(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

@Getter
@ToString
class Person_D {
    String name;
    int age;

    @Override
    public String toString() {
        return "Person_D{name='" + name + "', age=" + age + '}';
    }

}

record Person1(String name, int age) {

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

@Data
record Person4(String name, int age) {
}

@Data
class R {
    private final Object a;
    private final String b;
    private final int c;
    private final double d;
    private final float e;
    private final int[] arr;
}

@Value
record Person6(String name, int age) {
}

@Value
class Person7 {
    String name;
    int age;
}
