import org.junit.Assert
import org.junit.Test


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
}
