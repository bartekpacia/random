package tech.pacia

fun main() {
    val name = "Kotlin"
    println("Hello, " + name + "!")

    for (i in 1..5) {
        println("i = $i")
    }
}

interface Animal {
    fun makeSound(): String
}

class Elephant : Animal {
    override fun makeSound(): String = "Trumpet!"
}
