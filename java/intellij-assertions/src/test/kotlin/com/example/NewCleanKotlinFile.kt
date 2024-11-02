package com.example

import org.assertj.core.api.Assertions
import org.assertj.core.api.ListAssert
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

class NewCleanKotlinFile {
    @Test
    fun test() {
        val list = listOf(1, 2, 3)
        val a: ListAssert<Int> = Assertions.assertThat<Int>(list)
        val b = a.element(1)
        a.isEqualTo("2")

        val d = 1.0
        assertEquals(1.0, d, 0.0) // fine.
        assertEquals(1.0, d) // 'assertEquals()' between inconvertible types 'Double' and 'Int'
        assertEquals(1, d) // Doesn't complain even though perhaps it should.
    }
}
