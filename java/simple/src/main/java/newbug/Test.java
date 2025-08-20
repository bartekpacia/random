package newbug;

import java.util.Objects;

import static java.util.Objects.deepEquals;
import java.util.Arrays;

public class Test {
    void collectNames() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        deepEquals(arr1, arr2);
        java.util.stream.IntStream.range(0, arr1.length).forEach(i -> {
            int a = arr1[i];
            int b = arr2[i];
            java.util.Objects.requireNonNull("");
            boolean result = deepEquals(a, b);
            System.out.println("result is " + result);
        });
    }
}



class Foo {
    void test(String[] baz) {
        Arrays.sort(baz);
        Arrays.sort(baz);
    }
}