package com.example;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.api.InstanceOfAssertFactory;
import org.assertj.core.api.MapAssert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BlahBlah22 {
    @Test
    public void falseNegative1() {
        class MyList<T> extends ArrayList<Integer> { }
        MyList<String> list = new MyList<>();
        // Another flavor of types-are-compatible error
        Assertions.assertThat(List.of("a", "b", "c")).isEqualTo(list);
    }

    @Test
    public void falseNegative2() {
        Assertions.assertThat(List.of(1, 2.0, 3))
                .element(1, InstanceOfAssertFactories.DOUBLE)
                // We have AbstractDoubleAssert here which is not convertible to BigInteger, but no warning
                .isEqualTo(BigInteger.ONE);
    }

    @Test
    public void falsePositive1() {
        UnsupportedOperationException uoe = new UnsupportedOperationException();
        Assertions.assertThat(new IllegalArgumentException("Hello", uoe))
                .rootCause().isEqualTo(uoe);
    }

    @Test
    public void falsePositive2() {
        Assertions.assertThat(List.of(1, 2, 3))
                .flatMap(e -> List.of(String.valueOf(e)))
                .isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    public void falsePositive3() throws IOException {
        byte[] data = {1, 2, 3};
        Files.write(Path.of("test.dat"), data);
        File file = new File("test.dat");
        Assertions.assertThat(file)
                .binaryContent()
                // AbstractByteArrayAssert here
                .isEqualTo(data);
    }

    @Test
    public void falsePositive4() {
        Map<Integer, String> map = Map.of(1, "a", 2, "b");
        Assertions.assertThat(map)
                .extractingByKey(1)
                .isEqualTo("a");
    }
}
