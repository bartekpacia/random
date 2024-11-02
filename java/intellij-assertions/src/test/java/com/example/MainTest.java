package com.example;

import org.assertj.core.api.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyList<T> extends ArrayList<Integer> {
}

class MySampleTest23 {
  @Test
  public void testNoHighlightBecauseCorrect() {
    Stream<String> stream = Stream.of("a", "b", "c");
    List<String> list = List.of("a", "b", "c");
    Assertions
      .assertThat(stream)
      .isEqualTo(list);
  }

  @Test
  public void testNoHighlightBecauseCorrect_complexCase() {
    Stream<CharSequence> stream = Stream.of("a", "b", "c");
    List<String> list = List.of("a", "b", "c");
    Assertions
      .assertThat(stream)
      .isEqualTo(list);
  }

  @Test
  public void testNoHighlightBecauseCorrect_complexCase2() {
    Stream<CharSequence> stream = Stream.of("a", "b", "c");
    List<String> list = List.of("a", "b", "c");
    Assertions
      .assertThat(stream)
      .isEqualTo(list);
  }

  @Test
  public void testExtractingNoHighlight_destructured() {
    ListAssert<Integer> a = Assertions.assertThat(List.of(1));
    AbstractListAssert<?, /*actual*/ List<? extends String>, /* actual element*/ String, ObjectAssert<String>> b = a.extracting(e -> e.toString());
    var c = b.singleElement();
    var d = c.isEqualTo(1);
  }
}

class MySampleTest223 {
  @Test
  void testHighlightBecauseIncorrect_696969() {
    Stream<CharSequence> stream = Stream.of("a", "b", "c");
    List<String> list = List.of("a", "b", "c");
    Assertions
      .assertThat(stream)
      .isEqualTo(list);
  }

  @Test
  void testHighlightBecauseIncorrect() {
    final var myList = new MyList<String>();
    myList.add(1);
    Assertions.assertThat(myList)
      .last()
      .isEqualTo(1);
  }

  @Test
  void testExtractingHighlightBecauseIncorrect() {
    Supplier<Function<String, Integer>> giveMeFunction = () -> (String value) -> Integer.valueOf(value);
    Assertions.assertThat(List.of("1"))
      .extracting(giveMeFunction.get())
      .singleElement()
      .isEqualTo("1");
    // .<warning descr="'isEqualTo()' between objects of inconvertible types 'Integer' and 'String'">isEqualTo</warning>("1");
  }

  @Test
  void testExtractingNoHighlightBecauseCorrect() {
    Supplier<Function<String, Integer>> giveMeFunction = () -> (String value) -> Integer.valueOf(value);
    Assertions.assertThat(List.of("1"))
      .extracting(giveMeFunction.get())
      .singleElement()
      .isEqualTo(1);
  }
}

class RecursiveAssertJIntelliJIssueTest12 {
  @Test
  void recursiveComparison() {
    class A {
      int value;
    }
    class B {
      int value;
    }

    A actual = new A();
    actual.value = 1;

    B expected = new B();
    expected.value = 1;

    Assertions.assertThat(actual)
      .usingRecursiveComparison()
      .isEqualTo(expected);
  }
}

class Super {
  protected int value;

  @Test
  void testExtractingNoHighlight() {
    NullPointerException cause = new NullPointerException();
    IllegalArgumentException e = new IllegalArgumentException(cause);
    var acause = Assertions.assertThat(e).cause();
    Assertions.assertThat(e).cause().isSameAs("hello");
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Super aSuper = (Super) o;
    return value == aSuper.value;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
}

class Sub1 extends Super {
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}

class Sub2 extends Super {
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}

class Holder {
  int insideValue;
}

class MainTest4 {
  @Test
  public void falsePositive4() {
    Map<Integer, String> map = Map.of(1, "a", 2, "b");
    Assertions.assertThat(map)
      .extractingByKey(1)
      .isEqualTo("a");
  }

  @Test
  void testExtractingWithString() {
    Assertions.assertThat(new Holder())
      .extracting("insideValue")
      .isEqualTo(0);
  }

  @Test
  void testExtractingNoHighlightBecauseCorrect2() {
    Assertions.assertThat(Integer.valueOf(1))
      .extracting((Math.random() > 0.5) ? (Integer a) -> new Sub1() : (Integer b) -> new Sub2())
      .isEqualTo(new Super());
  }

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
  public void myTest_12() {
    Stream<String> stream1 = Stream.of("a", "b", "c"); // checkType
    Stream<Integer> stream2 = Stream.of(1, 2, 3); // sourceType
    Assertions
      .assertThat(stream1)
      .isEqualTo(stream2);
    //.<warning descr="'isEqualTo()' between objects of inconvertible types 'Stream<String>' and 'Stream<Integer>'">isEqualTo</warning>(stream2);
  }


  @org.junit.jupiter.api.Test
  public void myTest232() {
    assertEquals(1, "", "error message");
    assertEquals(1, "", () -> "error message in supplier");
    assertEquals(1, 42, "message");
    assertEquals(1, 42, () -> "message");
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
    ListAssert<String> a = Assertions.assertThat(stream); // sourceType is Stream<String>
    var b = a.isEqualTo(list); // checkType is List<String>
  }

  @org.junit.jupiter.api.Test
  public void myTest23() {
    Stream<String> stream = Stream.of("a", "b", "c");
    List<Integer> list = List.of(1, 2, 3);
    Assertions
      .assertThat(stream)
      .isEqualTo(list);
  }


  @Test
  void testExtractingNoHighlightBecauseCorrect232() {
    Supplier<Function<Integer, String>> giveMeFunction = () -> (Integer value) -> value.toString();
    Assertions.assertThat(Integer.valueOf(1))
      .extracting(giveMeFunction.get())
      .isEqualTo("1");
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

  @Test
  void testExtractingNoHighlightBecauseCorrect() {
    Assertions.assertThat(Integer.valueOf(1))
      .extracting(false ? null : Object::toString)
      .isEqualTo("1");
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
    Assertions.assertThat(List.of("1")) // sourceType is List<String>
      .extracting(elem -> Integer.valueOf(elem)) // sourceType: List<String> -> List<Integer>
      .singleElement()  // sourceType: List<Integer> -> Integer
      .isEqualTo("1"); // sourceType (Integer) is! checkType (String)
    // .<warning descr="'isEqualTo()' between objects of inconvertible types 'Integer' and 'String'">isEqualTo</warning>("1");
  }

  @Test
  void testExtractingHighlightBecauseIncorrect() {
    Assertions.assertThat(Integer.valueOf(1))
      .as("Mapping to String")
      .extracting(integer -> integer.doubleValue())
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
