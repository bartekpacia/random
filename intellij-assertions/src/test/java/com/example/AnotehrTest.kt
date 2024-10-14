package com.example

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.util.function.Function
import java.util.function.Supplier

internal class Holde {
    var insideValue: MutableList<String?> = mutableListOf<String?>("1")
}


internal class MySampleTest2 {
    @Test
    fun testExtractingNoHighlightBecauseCorrect() {
        Assertions.assertThat<Holder?>(Holder())
            .extracting("insideValue")
            .isEqualTo(mutableListOf<String?>("1"))

        java.util.List.of<String>("1")
    }

    @Test
    fun testExtractingNoHighlightBecauseUnsupported() {
        Assertions.assertThat<Holder?>(Holder())
            .extracting("insideValue")
            .isEqualTo(mutableListOf<Int?>(1)) // should warn that List<String> and List<Integer> are incompatible, but we don't support it for now
    }


    @Test
    fun testExtractingHighlightBecauseIncorrect_complexCase() {
        val giveMeFunction: Supplier<Function<Int?, String?>?> =
            Supplier { Function { value: Int? -> value.toString() } }
        Assertions.assertThat(1)
            .extracting<String?>(giveMeFunction.get())
    }

    @Test
    fun testExtractingNoHighlightBecauseCorrect_complexCase() {
        val giveMeFunction: Supplier<Function<Int?, String?>?> =
            Supplier { Function { value: Int? -> value.toString() } }
        Assertions.assertThat(1)
            .extracting<String?>(giveMeFunction.get())
            .isEqualTo("1")
    }
}
