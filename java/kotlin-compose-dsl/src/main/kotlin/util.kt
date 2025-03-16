package tech.pacia


/**
 * Packs two Float values into one Long value for use in inline classes.
 */
inline fun packFloats(val1: Float, val2: Float): Long {
    val v1 = val1.toRawBits().toLong()
    val v2 = val2.toRawBits().toLong()
    return (v1 shl 32) or (v2 and 0xFFFFFFFF)
}


/**
 * Packs two Int values into one Long value for use in inline classes.
 */
inline fun packInts(val1: Int, val2: Int): Long {
    return (val1.toLong() shl 32) or (val2.toLong() and 0xFFFFFFFF)
}

/**
 * Unpacks the first Int value in [packInts] from its returned ULong.
 */
inline fun unpackInt1(value: Long): Int {
    return (value shr 32).toInt()
}

/**
 * Unpacks the second Int value in [packInts] from its returned ULong.
 */
inline fun unpackInt2(value: Long): Int {
    return (value and 0xFFFFFFFF).toInt()
}

@kotlin.jvm.JvmInline
value class IntSize internal constructor(@PublishedApi internal val packedValue: Long) {
    /**
     * The horizontal aspect of the size in [Int] pixels.
     */

    val width: Int
        get() = unpackInt1(packedValue)

    /**
     * The vertical aspect of the size in [Int] pixels.
     */

    val height: Int
        get() = unpackInt2(packedValue)


    inline operator fun component1(): Int = width


    inline operator fun component2(): Int = height

    /**
     * Returns an IntSize scaled by multiplying [width] and [height] by [other]
     */

    operator fun times(other: Int): IntSize = IntSize(
        packInts(
            unpackInt1(packedValue) * other,
            unpackInt2(packedValue) * other
        )
    )

    /**
     * Returns an IntSize scaled by dividing [width] and [height] by [other]
     */

    operator fun div(other: Int): IntSize = IntSize(
        packInts(
            unpackInt1(packedValue) / other,
            unpackInt2(packedValue) / other
        )
    )


    override fun toString(): String = "$width x $height"

    companion object {
        /**
         * IntSize with a zero (0) width and height.
         */
        val Zero = IntSize(0L)
    }
}
