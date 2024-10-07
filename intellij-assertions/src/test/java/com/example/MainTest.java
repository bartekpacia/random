package com.example;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.OptionalLongAssert;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.SECONDS;

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

  @org.junit.jupiter.api.Test
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

  @org.junit.jupiter.api.Test
  void streamAndListPass() {
    Stream<String> stream = Stream.of("a", "b", "c");
    List<String> list = List.of("a", "b", "c");
    Assertions
      .assertThat(stream) // sourceType is Stream<String>
      .isEqualTo(list); // checkType is List<String>
  }

  @org.junit.jupiter.api.Test
  public void myTest23() {
    Stream<String> stream = Stream.of("a", "b", "c");
    List<Integer> list = List.of(1, 2, 3);
    Assertions
            .assertThat(stream)
            .isEqualTo(list);
  }

  @org.junit.jupiter.api.Test
  void completableFutureWarn() {
    CompletableFuture<Integer> future = CompletableFuture.completedFuture(1);
    Assertions
      .assertThat(future) // sourceType is CompletableFuture<Integer>
      .isEqualTo(1); // checkType is int
  }

  @org.junit.jupiter.api.Test
  void completableFuturePass() {
    CompletableFuture<Integer> future = CompletableFuture.completedFuture(1);
    Assertions
      .assertThat(future) // sourceType is CompletableFuture<Integer>
      .succeedsWithin(1, SECONDS) // sourceType becomes Integer
      .isEqualTo(1); // checkType is Integer
  }

  @org.junit.jupiter.api.Test
  public void myTest_1() {
    Stream<String> stream1 = Stream.of("a", "b", "c");
    Stream<String> stream2 = Stream.of("a", "b", "c");
    Assertions
      .assertThat(stream1)
      .isEqualTo(stream2);
  }

  @org.junit.jupiter.api.Test
  public void myTest76() {
    String rawStr = "test-string";
    Optional<String> wrappedStr = Optional.of(rawStr);
    Assertions
            .assertThat(wrappedStr)
            .isPresent()
            .get()
            .isEqualTo(rawStr)
            .isEqualTo(rawStr);
  }

  @Test
  void testSingleElement2() {
    Assertions.assertThat(List.of("1"))
            .extracting(elem -> Integer.valueOf(elem))
            .singleElement()
            .isEqualTo("1");
            // .<warning descr="'isEqualTo()' between objects of inconvertible types 'Integer' and 'String'">isEqualTo</warning>("1");
  }

  @Test
  void testExtractingHighlightBecauseIncorrect() {
    Assertions.assertThat(Integer.valueOf(1))
            .as("Mapping to String")
            .extracting(Integer::doubleValue)
            .isEqualTo("1");
  }

  @org.junit.jupiter.api.Test
  public void myTest4() {
    OptionalLongAssert a = Assertions.assertThat(OptionalLong.of(2));


    Assertions.assertThat(Optional.of("hello")).get().isEqualTo("hello");
    Assertions.assertThat(Optional.of("hello")).get().isNotEqualTo("bye");

    Assertions.assertThat(OptionalInt.of(1).getAsInt()).isNotEqualTo(2);
    Assertions.assertThat(OptionalInt.of(1).getAsInt()).isEqualTo(1);

    Assertions.assertThat(OptionalLong.of(1).getAsLong()).isEqualTo(1);
    Assertions.assertThat(OptionalLong.of(1).getAsLong()).isNotEqualTo(2);
  }

  void testSingleElement() {
    Assertions.assertThat(List.of("1"))
            .extracting(elem -> Integer.valueOf(elem))
            .singleElement()
            .isEqualTo("1");

  }
}

