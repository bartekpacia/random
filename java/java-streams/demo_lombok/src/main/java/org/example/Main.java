package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
class User {
    private String name;
    private int age;
}

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}