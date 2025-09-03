package records;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("John", 25);
        System.out.println("Name is " + p.getName() + " and age is " + p.getAge());
    }
}

class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
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

// Case where semantics changes: 
/*
class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    Person(CharSequence name, int age) {
        this.name = name.toString();
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
*/