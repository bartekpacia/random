import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class VoidTypeTests {
  private Void func() {
    return null;
  }

  @Test
  public void myTest() {
    Integer expected = Integer.valueOf(1);
    Void actual = func();
    Assert.assertEquals(expected, actual);
  }

  public void testComplex22(Optional<String> opt) {
    if (opt == null) opt = Optional.empty();
    if (opt.isPresent()) {
      Object obj = opt.get();
      use(obj instanceof Integer ? "foo" : "bar");
    }
  }

  void use(String obj) {
    System.out.println("String");
  }
}

// Assert.<warning descr = "'isEqualTo()' between objects of inconvertible types 'Integer' and 'Void'" > assertEquals < / warning > (expected, actual);

class Super {
  private int x;

  public void bruh(Optional<Sub> opt) {
    if (opt == null) opt = Optional.empty();
    if (opt.isPresent()) {
      // Changing type of `obj` from Super to Sub will change cause a compile-time error (field x is private). Hence, don't suggest fix.
      Super obj = opt.get();
      // target type: we can learn it from the generic that Optional holds
      use(obj.x);
    }
  }

  void use(Object obj) {
    System.out.println("Object");
  }
}

class Sub extends Super {}