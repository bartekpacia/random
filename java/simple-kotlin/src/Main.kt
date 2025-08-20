fun main() {
    val name = "Kotlin"
    println("Hello, $name!")
    for (i in 1..5) {
        println("i = $i")
    }
}

class Wrapper {
    class Application {
        companion object {
            @JvmStatic
            fun main(args: Array<String>) {
                println("hi!")
            }
        }
    }
}