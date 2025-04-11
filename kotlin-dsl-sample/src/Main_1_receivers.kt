// Let's talk about receivers.
// Receiver is simply the object on which a function/method is called.
// Almost every object-oriented programming language has this concept.
// But in most of them, when you declare a function, the receiver is implicit. 

// In Kotlin, function can have the receiver declared either implicitly or explicitly.

fun main() {
    val cat = Cat("Bolinha")
    cat.meow()
    cat.walk()
}

class Cat {
    val name: String

    constructor(name: String) {
        this.name = name
    }

    // Receiver is declared implicitly. Can be accessed with 'this'.
    fun meow() {
        println("${this.name} is meowing")
    }
}

// Now let's declare an extension function on the Cat class.
// Notice that receiver is declared explicitly and it can be accessed with 'this'.
fun Cat.walk() {
    println("${this.name} is walking")
}

// It may seem minor, but this feature is quite powerful.
