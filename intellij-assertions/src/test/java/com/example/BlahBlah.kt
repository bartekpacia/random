package com.example

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.util.stream.Stream

import kotlin.test.assertEquals

class MySampleTest32 {
    @Test
    fun myTest_1() {
        val stream1 = Stream.of("a", "b", "c")
        val stream2 = Stream.of(1, 2, 3)
        Assertions
            .assertThat(stream1)
            .isEqualTo(stream2)
    }

    @Test
    fun test() {
        val d = 1.0
        assertEquals(1.0, d, 0.0) // fine.
        // assertEquals(1.0, d, 0) // 'assertEquals()' between inconvertible types 'Double' and 'int'
        // assertEquals(1, d, 0.0) // Doesn't complain even though perhaps it should.
    }
}
