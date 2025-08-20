package IDEA375458;

import java.util.Objects;

import static java.util.Objects.*;

public class Main {
  void collectNames() {
    int[] arr1 = {1, 2, 3};
    int[] arr2 = {1, 2, 3};
    deepEquals(arr1, arr2);
    for (int i = 0; i < arr1.length; i++) {
      int a = arr1[i];
      int b = arr2[i];
      Objects.requireNonNull("");
      boolean result = deepEquals(a, b);
      System.out.println("result is " + result);
    }
  }
}
