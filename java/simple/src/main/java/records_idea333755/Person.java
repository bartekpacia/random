package records_idea333755;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface OnlyForMethods {
}

@Target(ElementType.METHOD)
@interface MethodAnno {
}

record Person(
        @Deprecated String name,
        @MethodAnno int age,
        @MethodAnno Person.Address address
) {
    class Address {
    }
}


