package org.example;

import lombok.Value;

import java.util.List;

@Value
class User {
    String name;
    int age;
    static int lol;
}

public class Main {
    public static void main(String[] args) {
        List<String> a;
        User user = new User("Louis", 27);
        System.out.printf("Hello and welcome!");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}
