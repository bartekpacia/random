import org.junit.Assert;
import org.junit.Test;

public class SomeTests {

  @Test
  public void very() throws InterruptedException {
    Thread.sleep((long) (Math.random() * 500));
    Assert.assertTrue(true);
  }

  @Test
  public void random() throws InterruptedException {
    Thread.sleep((long) (Math.random() * 500));
    Assert.assertTrue(true);
  }

  @Test
  public void tests() throws InterruptedException {
    Thread.sleep((long) (Math.random() * 500));
    Assert.assertTrue(true);
  }
}
