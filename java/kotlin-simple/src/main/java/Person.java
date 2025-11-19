package tech.pacia;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Person {
    final String name;
    final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        int a = "xd" + 10;
    }

    void bar(List<String> x) {
        System.out.println(x.get(0));
        System.out.println(x);
        Stream.of(1, 2, 3).map(i -> i).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Person p = new Person("Alice", 30);
        p.bar(List.of("Hello", "World"));
    }
}

