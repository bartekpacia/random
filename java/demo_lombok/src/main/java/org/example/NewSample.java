package org.example;

record Person2(String name, int age) {
    String getInfo() {
        return "Person " + name + " is " + age + " years old";
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

class Foo2 {
    void foo() {
        Person2 person = new Person2("Charlie", 42);
        // Renaming getters to accessors requires the Lombok plugin
        System.out.println("Person " + person.getName() + " is " + person.getAge() + " years old");
    }
}
