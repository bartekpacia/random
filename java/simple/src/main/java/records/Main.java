package records;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("John", 25);
        System.out.println("Name is " + p.getName());
    }
}

class Person {
    private final String name;
    private final int age;

    Person(CharSequence charSequence, int age) {
        this.name = charSequence.toString().trim();
        this.age = age;
    }

    public String getName() {
        return name;
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