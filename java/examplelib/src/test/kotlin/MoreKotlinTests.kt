import org.junit.Assert
import org.junit.Test


interface FileManager {
    @JvmInline
    value class Command<T>(val key: String)
}

object FileManagerPropertyKeys {
    val RevealFile: FileManager.Command<String> = FileManager.Command("aaa")
}


class MoreKotlinTests {
    @Test
    fun myTest() {
        val actual: String = "aaa"
        Assert.assertEquals(FileManagerPropertyKeys.RevealFile, actual)
    }
}