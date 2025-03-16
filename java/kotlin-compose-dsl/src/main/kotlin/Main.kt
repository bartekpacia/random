package tech.pacia

import kotlin.math.roundToInt


fun main() {
    // How does this work?
    Row {
        Text(
            text = "Hello world",
            // This Text is inside a RowScope so it has access to
            // Alignment.CenterVertically but not to
            // Alignment.CenterHorizontally, which would be available
            // in a ColumnScope.
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

//region common declarations

fun Text(text: String, modifier: Modifier) {}

data class BiasAlignment(
    val horizontalBias: Float,
    val verticalBias: Float,
) : Alignment {
    override fun align(
        size: IntSize,
        space: IntSize,
        layoutDirection: LayoutDirection,
    ): IntOffset {
        return IntOffset(0)
    }

    /**
     * An [Alignment.Horizontal] specified by bias: for example, a bias of -1 represents alignment
     * to the start, a bias of 0 will represent centering, and a bias of 1 will represent end.
     * Any value can be specified to obtain an alignment. Inside the [-1, 1] range, the obtained
     * alignment will position the aligned size fully inside the available space, while outside the
     * range it will the aligned size will be positioned partially or completely outside.
     *
     * @see BiasAbsoluteAlignment.Horizontal
     * @see Vertical
     */

    data class Horizontal(val bias: Float) : Alignment.Horizontal {
        override fun align(size: IntSize, space: IntSize): IntOffset {
            return IntOffset(0)
        }
    }

    /**
     * An [Alignment.Vertical] specified by bias: for example, a bias of -1 represents alignment
     * to the top, a bias of 0 will represent centering, and a bias of 1 will represent bottom.
     * Any value can be specified to obtain an alignment. Inside the [-1, 1] range, the obtained
     * alignment will position the aligned size fully inside the available space, while outside the
     * range it will the aligned size will be positioned partially or completely outside.
     *
     * @see Horizontal
     */
    data class Vertical(val bias: Float) : Alignment.Vertical {
        override fun align(size: IntSize, space: IntSize): IntOffset = IntOffset(0)
    }
}

/**
 * A two-dimensional position using [Int] pixels for units
 */
@JvmInline
value class IntOffset internal constructor(@PublishedApi internal val packedValue: Long) {
    /**
     * The horizontal aspect of the position in [Int] pixels.
     */
    val x: Int
        get() = unpackInt1(packedValue)

    /**
     * The vertical aspect of the position in [Int] pixels.
     */
    val y: Int
        get() = unpackInt2(packedValue)

    inline operator fun component1(): Int = x

    inline operator fun component2(): Int = y

    /**
     * Returns a copy of this IntOffset instance optionally overriding the
     * x or y parameter
     */
    fun copy(x: Int = unpackInt1(packedValue), y: Int = unpackInt2(packedValue)) =
        IntOffset(packInts(x, y))

    /**
     * Subtract a [IntOffset] from another one.
     */
    operator fun minus(other: IntOffset) =
        IntOffset(
            packInts(
                unpackInt1(packedValue) - unpackInt1(other.packedValue),
                unpackInt2(packedValue) - unpackInt2(other.packedValue)
            )
        )

    /**
     * Add a [IntOffset] to another one.
     */
    operator fun plus(other: IntOffset) =
        IntOffset(
            packInts(
                unpackInt1(packedValue) + unpackInt1(other.packedValue),
                unpackInt2(packedValue) + unpackInt2(other.packedValue)
            )
        )

    /** Returns a new [IntOffset] representing the negation of this point. */
    operator fun unaryMinus() =
        IntOffset(packInts(-unpackInt1(packedValue), -unpackInt2(packedValue)))

    /**
     * Multiplication operator.
     *
     * Returns an IntOffset whose coordinates are the coordinates of the
     * left-hand-side operand (an IntOffset) multiplied by the scalar
     * right-hand-side operand (a Float). The result is rounded to the nearest integer.
     */
    operator fun times(operand: Float): IntOffset = IntOffset(
        packInts(
            (unpackInt1(packedValue) * operand).roundToInt(),
            (unpackInt2(packedValue) * operand).roundToInt(),
        )
    )

    /**
     * Division operator.
     *
     * Returns an IntOffset whose coordinates are the coordinates of the
     * left-hand-side operand (an IntOffset) divided by the scalar right-hand-side
     * operand (a Float). The result is rounded to the nearest integer.
     */
    operator fun div(operand: Float): IntOffset = IntOffset(
        packInts(
            (unpackInt1(packedValue) / operand).roundToInt(),
            (unpackInt2(packedValue) / operand).roundToInt(),
        )
    )

    /**
     * Modulo (remainder) operator.
     *
     * Returns an IntOffset whose coordinates are the remainder of dividing the
     * coordinates of the left-hand-side operand (an IntOffset) by the scalar
     * right-hand-side operand (an Int).
     */
    operator fun rem(operand: Int) = IntOffset(
        packInts(
            unpackInt1(packedValue) % operand,
            unpackInt2(packedValue) % operand
        )
    )

    override fun toString(): String = "($x, $y)"

    companion object {
        val Zero = IntOffset(0x0L)
    }
}

enum class LayoutDirection { Ltr, Rtl }

interface Modifier {
    companion object : Modifier
}

fun interface Alignment {
    fun align(size: IntSize, space: IntSize, layoutDirection: LayoutDirection): IntOffset

    fun interface Horizontal {
        fun align(size: IntSize, space: IntSize): IntOffset
    }

    fun interface Vertical {
        fun align(size: IntSize, space: IntSize): IntOffset
    }

    companion object {
        // 1D Alignment.Verticals.
        val Top: Alignment.Vertical = BiasAlignment.Vertical(-1f)

        val CenterVertically: Alignment.Vertical = BiasAlignment.Vertical(0f)
        val Bottom: Alignment.Vertical = BiasAlignment.Vertical(1f)

        // 1D Alignment.Horizontals.
        val Start: Alignment.Horizontal = BiasAlignment.Horizontal(-1f)
        val CenterHorizontally: Alignment.Horizontal = BiasAlignment.Horizontal(0f)
        val End: Alignment.Horizontal = BiasAlignment.Horizontal(1f)
    }
}

//endregion

fun Row(content: RowScope.() -> Unit) {
    content.invoke(object : RowScope {
        override fun Modifier.align(alignment: Alignment.Vertical): Modifier {
            TODO("Not yet implemented")
        }
    })
}

interface RowScope {
    fun Modifier.align(alignment: Alignment.Vertical): Modifier
}
