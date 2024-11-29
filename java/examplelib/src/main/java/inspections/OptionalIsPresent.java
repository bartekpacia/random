package inspections;

import java.util.Optional;

public class OptionalIsPresent {
  public static void main(String[] args) {
    OptionalIsPresent obj = new OptionalIsPresent();
    obj.testOptional_indirect_typeCheck(Optional.of("hej"));
  }

  public void testOptional(Optional<String> str) {
    if (str.isEmpty()) str = Optional.empty();
    str.ifPresent(obj -> System.out.println(obj + ":" + obj));
  }

  public void testOptional_indirect_typeCheck(Optional<String> str) {
    if (str.isEmpty()) str = Optional.empty();
    if (str.isPresent()) {
      Object obj = str.get();
      use(obj);
    }
  }

  void use(Object obj) {
    System.out.println("Object");
  }

  void use(String obj) {
    System.out.println("String");
  }
}

