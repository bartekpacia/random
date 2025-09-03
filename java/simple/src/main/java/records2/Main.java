package records2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("John", 25, new ArrayList<>());
        System.out.println("Name is " + p.getName());
    }
}

class Person<T> {
    private final String name;
    private final int age;
    private final ArrayList<? extends T> ARR_LIST;

    Person(CharSequence DUPA, int age, List<? extends T> t) {
        this.name = DUPA.toString();
        this.age = age;
        this.ARR_LIST = new ArrayList<>(t);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", t=" + ARR_LIST +
                '}';
    }
}