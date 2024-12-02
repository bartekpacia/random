package testsuite;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubtractionTest {

  @Test
  void testSubtraction() {
    Calculator calculator = new Calculator();
    assertEquals(2, calculator.subtract(5, 3));
  }
}
