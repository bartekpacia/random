import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
  println("hello world")
  assert(2 + 2 == 4)
  println("hello everyone!")
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