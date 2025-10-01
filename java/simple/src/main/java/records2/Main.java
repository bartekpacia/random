package records2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Person p = new Person("John", 25, new ArrayList<>());
//        System.out.println("Name is " + p.getName());
    }
}

class Person {
    final String name;
    final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(String name) {
        this.name = name;
        this.age = 42;
    }

    Person(int age) {
        this("Unknown", age);
    }
}
