// https://ponomarev.uk/blog/variance.html

package com.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // arrays();
        lists_1();
        heapPollution();
    }

    private static void arrays() {
        // Just objects
        Person person;
        Employee employee = new Manager();
        // Manager manager = new Employee(); // compile-time error

        // Arrays

        Manager[] managers = new Manager[3];
        managers[0] = new Manager();

        Object[] objects;
        Person[] persons;
        Manager[] cars;

        objects = managers;
        objects[2] = new Employee(); // fails at runtime with ArrayStoreException
        // That's because arrays in Java are reified - they know at runtime what type of elements they contain.

        persons = managers;
        // persons[2] = new Airplane();
        // 

        objects = persons; // we can do this
        // In other words, Java considers Person[] as a subtype of Object[]. This means that arrays are covariant.

        for (Person p : persons) {
            System.out.println("person.getClass() = " + p.getClass());
        }
    }

    private static void lists_1() {
        List<Manager> managers = new ArrayList<>();
        List<?> anything = managers;
        // List<Person> person = managers; // compile-time error

        // List<Manager>[] managersArr = new ArrayList<Manager>[10]; // compile-time error: Generic array creation not allowed

        for (Object obj : anything) {
            System.out.println("obj.getClass() = " + obj.getClass());
        }
    }

    private static void lists_2() {
        List<? extends Person> persons_out = new ArrayList<>();
        persons_out.add(new Person());
        Person person = persons_out.get(0);
        
        List<? super Person> persons_in = new ArrayList<>();
        persons_in.add(new Person());
        Person person2 = persons_in.get(0);
    }

    private static void heapPollution() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        List<?> unknowns = ints;
        List<String> strings = (List<String>) unknowns;
        strings.add("Hello");

        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        System.out.println(sb.toString());
    }
}

class Person {
}

class Employee extends Person {
}

class Manager extends Employee {
}
