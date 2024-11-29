import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SomeJUnit4Test {
  @Nullable
  String getNullableString() {
    double random = Math.random();
    if (random > 0.75) return null;
    if (random > 0.50) return "";
    else return "bruh";
  }

  @Test
  public void test() {
    String s = getNullableString();
    assertTrue(s.isEmpty());
  }
}
