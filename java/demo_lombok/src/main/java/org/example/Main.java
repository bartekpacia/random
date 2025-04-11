package org.example;

import lombok.Value;

import java.util.List;

@Value
class User {
    String name;
    int age;

    static int lol;
}

@Value
class Person {
    private String name; // redundant because (1)
    final int age; // redundant because (2)
    private final String city; // redundant because (1) and (2)
}



class Foo {
    private int bar;
    private boolean baz;

    public int getBar() {
        return bar;
    }

    public boolean isBaz() {
        return baz;
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> a;
        User user = new User("Louis", 27);
        Person person = new Person("Bart", 29, "Utrecht");
        System.out.printf("Hello and welcome!");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        System.out.println("person " + person.getName() + " lives in " + person.getCity());
    }
}
