package records3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // T is instantiated as String
        List<String> stringList = new ArrayList<>();
        new Selector<>(stringList);

        List<Integer> integerList = new ArrayList<>();
        new Selector<>(integerList);
    }
}

class Selector<T> {
    private final List<String> internalStorage;

    // Constructor 1: Takes a generic collection based on the class's type parameter T
    Selector(Collection<T> coll) {
        this.internalStorage = coll.stream().map(Object::toString).toList();
        System.out.println("-> Constructor(Collection<T>) was called.");
    }

    // Selector(List<String> lst); // Uncomment this code to see difference!
}

// Case 1 reasoning:
//  T -> String, call site is Selector(List<String>)
//  Step 1:
//   first constructor becomes Selector(Collection<String>)
//   second constructor becomes -> Selector(List<String>)
//  Step 2:
//   Both constructors are applicable.
//   but List<String> is more specific than Collection<String>
//   We select constructor 2

// Case 2 reasoning
//  T -> Integer, call site is Selector(ArrayList<Integer>)
//  Step 1:
//   first constructor becomes Selector(Collection<Integer>)
//   second constructor becomes Selector(List<Integer>)
//  Step 2:
//    ArrayList<Integer> is applicable to Collection<Integer>
//    ArrayList<Integer> is not applicable to List<String>
//    Only the first constructor is applicable, so we select it.