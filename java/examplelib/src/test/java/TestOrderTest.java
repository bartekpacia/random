import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOrderTest {

    final Supplier<Long> timeout = () -> (long) (Math.random() * 1000);

    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(timeout.get());
        assertTrue(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void test4(int val) throws InterruptedException {
        Thread.sleep(timeout.get());
        assertTrue(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void test2(int val) throws InterruptedException {
        Thread.sleep(timeout.get());
        assertTrue(true);
    }

    @Test
    public void test3() throws InterruptedException {
        Thread.sleep(timeout.get());
        assertTrue(true);
    }
}