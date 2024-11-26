package simple2;

import java.util.Optional;

public class Main {
  public static void main(String[] args) {
  }

  public void testIsPresent_2() {
    Optional<Object> opt = Optional.ofNullable(Math.random() > 0.5 ? new Object() : null);
    if (opt.isPresent()) {
      System.out.println(opt.get());
    }
  }

  public void testIsPresentIndirect() {
    Optional<Object> opt = Optional.ofNullable(Math.random() > 0.5 ? new Object() : null);
    if (opt.isPresent()) {
      Object obj = opt.get();
      System.out.println(obj);
    }
  }
}
