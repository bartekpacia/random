package breaking_final;

public class Main {
    public static void main(String[] args) {
        // var employee = new Employee("CAM-FORA", 42, "ok");
    }
}

class Person {
    final String name;
    final int age;

    void show() {
        System.out.println("Age: " + this.age);
    }

    Person(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("age must be >= 0");
        }
        this.name = name;
        this.age = age;
        show();
    }
}

//class Employee extends Person {
//    final String officeId;
//
//    @Override
//    void show() {
//        System.out.println("Age: " + age);
//        System.out.println("Office: " + this.officeId);
//    }
//
//    Employee(String name, int age, String officeId) {
//        if (age < 18 || age > 67) {
//            throw new IllegalArgumentException("too young or too old");
//        }
//        this.officeId = officeId; // requires Java 25 (JEP 513)
//        super(name, age); // show called here for the 1st time
//        System.out.println("now will call show for the 2nd time!");
//        show();
//    }
//}