package com.example;

// import org.junit.Assert.assertEquals
// import org.junit.jupiter.api.Assertions
import org.assertj.core.api.*
import org.assertj.core.groups.Tuple
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.math.BigInteger
import java.util.*
import kotlin.collections.HashSet

// import kotlin.test.assertEquals

// import kotlin.test.assertEquals

class MySampleTes213t {
  @Test
  fun testExtractingHighlightBecauseIncorrect() {
    val giveMeFunction: () -> ((String) -> Int) = { { value: String -> value.toInt() } }
    Assertions.assertThat(listOf("1"))
      .extracting(giveMeFunction())
      .singleElement()
      .isEqualTo("1")
  }

//    @Test
//    fun testExtractingNoHighlightBecauseCorrect() {
//        val giveMeFunction = { (value: String) -> value.toInt() }
//        Assertions.assertThat(listOf("1"))
//            .extracting(giveMeFunction.get())
//            .singleElement()
//            .isEqualTo(1)
//    }

  @Test
  fun blablah() {
    Assertions.assertThat(listOf("1"))
      .extracting({ elem -> elem.toInt() })
      .singleElement()
      .isEqualTo("1")
  }

  @Test
  fun testNoHighlightBecauseCorrect() {
    Assertions.assertThat(listOf("1"))
      .last()
      .isEqualTo("1")
  }

  @Test
  fun myTest() {
    val sourceList = listOf(1, 2, 3)
    val doubleAssert: AbstractDoubleAssert<*> = Assertions.assertThat(sourceList)
      .element(1, InstanceOfAssertFactories.DOUBLE)

    doubleAssert.isEqualTo(BigInteger.ONE)
  }

//    @Test
//    fun testNoHighlightBecauseCorrect_complexCase() {
//        val myList = MyList<String>()
//        myList.add(1)
//        Assertions.assertThat(myList)
//            .last()
//            .isEqualTo(1)
//    }

//    @Test
//    fun testHighlightBecauseIncorrect_complexCase() {
//        val myList = MyList<String>()
//        myList.add(1)
//        Assertions.assertThat(myList)
//            .last()
//            .< warning descr =
//            "'isEqualTo()' between objects of inconvertible types 'Integer' and 'String'" > isEqualTo < / warning >("1")
//    }

}


class SampleTest {
  @Test
  fun myTest1() {
    Assertions.assertThat("foo").isEqualTo(2)
    Assertions.assertThat("foo").isEqualTo("bar")
    Assertions.assertThat("foo").describedAs("foo").isEqualTo(2)
    Assertions.assertThat("foo").`as`("foo").isEqualTo(2)
  }


  @Test
  fun myTest2() {
    assertNotEquals("java", 1)
    assertNotEquals(intArrayOf(0), 1.0)
    assertNotEquals(intArrayOf(0), intArrayOf(1))
  }
}

class MyTest {
  @org.junit.jupiter.api.Test
  fun myTest() {
    assertEquals(1, "", "error message")
    assertEquals(1, "", { "error message in supplier" })
    assertEquals(1, 42, "message");
    assertEquals(1, 42, { "message" });
  }

  @Test
  fun testExtractingNoHighlight() {
    Assertions.assertThat(listOf(1))
      .extracting({ e -> e.toString() })
      .singleElement()
      .isEqualTo(1) // tuple != string
  }

  @Test
  fun testExtractingNoHighlight_destructured_1() {
    val a: ListAssert<Int> = Assertions.assertThat(listOf<Int>(1))
    // val b = a.extracting({ e -> e.toString() })
    val b: AbstractListAssert<*, /*actual*/ MutableList<out Tuple>, /* actual element*/ Tuple, ObjectAssert<Tuple>> =
      a.extracting({ e -> e.toString() })
    val c = b.singleElement()
    val d = c.isEqualTo(1)
  }

  @Test
  fun testExtractingNoHighlight_destructured_2() {
    val a: ListAssert<Int> = Assertions.assertThat(listOf<Int>(1))
    val b = a.extracting({ e -> e.toString() })
    // val b: AbstractListAssert<*, /*actual*/ MutableList<out Tuple>, /* actual element*/ Tuple, ObjectAssert<Tuple>> = a.extracting({ e -> e.toString() })
    val c = b.singleElement()
    val d = c.isEqualTo(1)

    kotlin.test.assertEquals<Any>(TreeSet<Int>(), HashSet<String>())
  }


}

internal class RecursiveAssertJIntelliJIssueTest {
  @Test
  fun recursiveComparison() {
    class A {
      var value: Int = 0
    }

    class B {
      var value: Int = 0
    }

    val actual = A()
    actual.value = 1

    val expected = B()
    expected.value = 1

    Assertions.assertThat(actual)
      .usingRecursiveComparison()
      .isEqualTo(expected)
  }
}

class MainTestKt {
//    companion object {
//        fun areEqual(a: Any, b: GenericClass<String>): Boolean {
//            return a.equals(b)
//        }
//    }

  @Test
  fun test() {
    val list = listOf(1, 2, 3)
    val a = Assertions.assertThat(list)
    val b = a.element(1)
    a.isEqualTo("2")

    val d = 1.0
    assertEquals(1.0, d, 0.0) // fine.
    assertEquals(1.0, d) // 'assertEquals()' between inconvertible types 'Double' and 'Int'
    assertEquals(1, d) // Doesn't complain even though perhaps it should.
  }

  @Test
  fun testFoo() {
    // org.junit.Assert.<warning descr="'assertEquals()' between objects of inconvertible types 'String' and 'double'">assertEquals</warning>("java", 1.0)
  }
}
