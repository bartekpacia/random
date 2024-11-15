import org.junit.Test;
import org.junit.Assert;

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
}

// Assert.<warning descr = "'isEqualTo()' between objects of inconvertible types 'Integer' and 'Void'" > assertEquals < / warning > (expected, actual);