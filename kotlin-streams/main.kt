import java.util.stream.Stream

fun main() {
    println("Hello World!")

    val a = Stream.of(1, 2, 3)
    a.map { it * 2 }
        .filter { it > 3 }
        .findFirst()
        .get()
        .let {
            println(it)
        }

    val b = listOf(1, 2, 3, 4, 5)
    val filter = b
        .asSequence()
        .map { it * 2 }
        .filter { it > 3 }
        .map { it + 69 }
        .forEach { println(it) }
}
