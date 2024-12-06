import org.junit.Assert;
import org.junit.Test;

public class SomeTests {

  final long shortTimeout = (long)(Math.random() * 5000);
  final long longTimeout = (long)(Math.random() * 7000);

  @Test
  public void alpha() throws InterruptedException {
    Thread.sleep(shortTimeout);
    Assert.assertTrue(true);
  }

  @Test
  public void bravo() throws InterruptedException {
    Thread.sleep(shortTimeout);
    Assert.assertTrue(true);
  }

  @Test
  public void charlie() throws InterruptedException {
    Thread.sleep(shortTimeout);
    Assert.assertTrue(true);
  }

  @Test
  public void delta() throws InterruptedException {
    Thread.sleep(longTimeout);
    Assert.assertTrue(true);
  }
}
