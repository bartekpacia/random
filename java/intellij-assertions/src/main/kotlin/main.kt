fun main() {
  val worker = Worker()
  worker.doWork()
  println("hi")
}

class Worker {
  fun doWork() {
    println("doing work")
  }
}
