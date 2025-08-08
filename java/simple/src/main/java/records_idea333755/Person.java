package records_idea333755;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface OnlyForMethods {
}

@Target(ElementType.METHOD)
@interface MethodAnno {
}

final class Person {
    @Deprecated
    private final String name;
    private final int age;
    private final Address address;

    Person(
            @Deprecated String name,
            int age,
            Address address
    ) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    Person(String name) {
        this(name, 0, new Address("Amphitheatre Pkwy", 1600));
    }

    @Deprecated
    @MethodAnno
    public String name() {
        return name;
    }

    @MethodAnno
    public int age() {
        return age;
    }

    @MethodAnno
    public Address address() {
        return address;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Person) obj;
        return Objects.equals(this.name, that.name) &&
                this.age == that.age &&
                Objects.equals(this.address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }

    @Override
    public String toString() {
        return "Person[" +
                "name=" + name + ", " +
                "age=" + age + ", " +
                "address=" + address + ']';
    }


    record Address(String street, int number) {
    }
}


