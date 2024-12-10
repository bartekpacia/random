import org.junit.Assert;
import org.junit.Test;

import java.util.function.Supplier;


public class SomeTests2 {
  final Supplier<Long> timeout = () -> (long) (Math.random() * 1000);

  @Test
  public void iAm() throws InterruptedException {
    Thread.sleep(timeout.get());
    Assert.assertTrue(true);
  }

  @Test
  public void blue() throws InterruptedException {
    Thread.sleep(timeout.get());
    Assert.assertTrue(true);
    System.out.println("xd");
    // xd
  }

  @Test
  public void daBaDee() throws InterruptedException {
    Thread.sleep(timeout.get());
    Assert.assertTrue(true);
  }

  @Test
  public void daBaDaaa() throws InterruptedException {
    Thread.sleep(timeout.get());
    Assert.assertTrue(true);
  }

  @Test
  public void blueAreTheFeelings() throws InterruptedException {
    Thread.sleep(timeout.get());
    Assert.assertTrue(true);
  }

  @Test
  public void thatLiveInsideMe() throws InterruptedException {
    Thread.sleep(timeout.get());
    Assert.assertTrue(true);
  }
}
