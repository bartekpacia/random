import kotlinx.coroutines.*

fun main() = runBlocking {
    val deferred1 = async {
        delay(1000L)
        println("Coroutine 1 finished after 1 second")
    }

    val deferred2 = async {
        delay(2000L)
        println("Coroutine 2 finished after 2 seconds")
    }

    val deferred3 = async {
        delay(3000L)
        println("Coroutine 3 finished after 3 seconds")
    }

    awaitAll(deferred1, deferred2, deferred3)

    println("All coroutines have finished")
}
