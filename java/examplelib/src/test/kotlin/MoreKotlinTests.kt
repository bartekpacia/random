import org.assertj.core.api.Assertions
import org.junit.Assert
import org.junit.Test
import org.assertj.core.api.Assertions.assertThat


interface FileManager {
    @JvmInline
    value class Command<T>(val key: String)
}

object FileManagerPropertyKeys {
    val RevealFile: FileManager.Command<String> = FileManager.Command("aaa")
}

@JvmInline
value class ValueClass(val prop: String)

typealias TypeAlias = Int

class MoreKotlinTests {
    @Test
    fun myValueClassTest() {
        val actual = ValueClass("xd")
        // Assert.assertEquals(FileManagerPropertyKeys.RevealFile, actual)
        Assert.assertEquals(ValueClass("foo"), "foo")
    }

    @Test
    fun myTypeAliasTest() {
        val expected: TypeAlias = 3
        val actual: Int = 3
        Assert.assertEquals(expected, actual)
        Assert.assertEquals(expected, "foo")
    }

    fun myValueClassTestAssertJ() {
        val a = ValueClass("a")
        val b = ValueClass("b")
        Assert.assertEquals(a, b)
        Assertions.assertThat(a).isEqualTo(b)
    }
}
