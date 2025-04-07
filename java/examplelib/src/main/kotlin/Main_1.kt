// Let's record an execution trace.

fun main() {

}

suspend fun a() {}

suspend fun b() {}
fun bar(a: Int): List<Int> {
  println("bar() is executed with input $a")
  return listOf(a, a + 1, a + 2)
}

fun baz(i: Int): Int {
  println("baz() is executed with input $i")
  return i
}

fun fizz(y: Int) {
  println("fizz() is executed with input $y")
}

fun foo(a: Int) {
  val x = bar(a)
  for (i in x) {
    val y = baz(i)
    if (y == i) {
      fizz(y)
    }
  }
}
