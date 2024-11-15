package pacia.tech

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch {
            a()
        }

        launch {
            b()
        }
    }
}

suspend fun a() {}

suspend fun b() {}