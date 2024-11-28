import org.jetbrains.annotations.Nullable;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class SomeTestNGTest {
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

// Assert.assertNotNull(s);