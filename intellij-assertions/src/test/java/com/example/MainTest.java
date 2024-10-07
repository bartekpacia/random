package com.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

public class MainTest {

    @org.junit.jupiter.api.Test
    public void myTest3() {
        String rawStr = "hello";
        Optional<String> wrappedStr = Optional.of(rawStr);
        Assertions
                .assertThat(wrappedStr)
                .isPresent()
                .isEqualTo(rawStr)
                .get()
                .isEqualTo(rawStr);
    }

    @Test
    public void myTest2() {
        String rawStr = "hello";
        Optional<String> wrappedStr = Optional.of(rawStr);
        Assertions
                .assertThat(wrappedStr)
                .get()
                .isEqualTo(rawStr);
    }

    @org.junit.jupiter.api.Test
    public void myTest() {
        String rawStr = "hello";
        Optional<String> wrappedStr = Optional.of(rawStr);
        Assertions
                .assertThat(123)
                .isEqualTo("xd");
    }

    Stream<String> stream = Stream.of("a", "b", "c");
    List<String> list = List.of("a", "b", "c");
        assertThat(stream)
        .isEqualTo(list);

    @Test
    void completableFutureSucceedsWithResult() {
        CompletableFuture<Integer> future = completedFuture(1);
        assertThat(future).succeedsWithin(1, SECONDS).isEqualTo(1);
    }
}
