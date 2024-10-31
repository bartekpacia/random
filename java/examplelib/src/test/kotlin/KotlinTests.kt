import org.junit.Assert
import org.junit.Test

class KotlinTests {
    @Test
    fun myTest() {
        val actual: String = "hello"
        val expected: Nothing? = null
        Assert.assertEquals(expected, actual)
        Assert.assertEquals(actual, expected)
    }
}
