package org.example;


public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        final var person = new Person("Bartek", 22);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
