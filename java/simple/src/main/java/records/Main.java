package records;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("John", 25);
        System.out.println("1st person is named " + p1.name());

        Person p2 = new Person("Paul", 42);
        System.out.println("2nd person's name is " + p2.name());

        Person p3 = new Person((CharSequence) "Paul", 42);
        System.out.println("3rd person!!!" + p3);

        Person p4 = new Person(10);
        System.out.println("4th person is " + p4);
    }
}

class Person {
    private final String name;
    private final int age;

    Person(CharSequence charSequence, int age) {
        this.name = charSequence.toString().trim();
        this.age = age;
    }

    Person(int age) {
        this("Unknown", age);
    }

    public String name() {
        return name;
    }

    public int age() {
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