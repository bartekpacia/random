package com.example.multiconstrecord3;

//import java.time.Duration;
//import java.util.concurrent.StructuredTaskScope;
//
//public class Main {
//  static void main() throws InterruptedException {
//    try (final var scope = new StructuredTaskScope.ShutdownOnFailure()) {
//      var task1 = scope.fork(() -> {
//        Thread.sleep(Duration.ofSeconds(5)); // Simulates a long-running task
//        return "Task 1 result";
//      });
//
//      var task2 = scope.fork(() -> {
//        Thread.sleep(Duration.ofSeconds(2));
//        return "Task 2 result";
//        // throw new RuntimeException("Task 2 failed");
//      });
//
//      scope.join();
//
//      String result = task1.get() + task2.get();
//      System.out.println("result = " + result);
//    }
//
//  }
//}
