package pacia.tech;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class JavaConcurrency {
  public static void main(String[] args) {
    try (final var scope = new StructuredTaskScope.ShutdownOnFailure()) {
      System.out.println("Task is starting");
      Subtask<String> subtask = scope.fork(() -> fetchData());
      scope.join();
      final String result = subtask.get();
      assert result.equals("data");
      System.out.println("Task finished, result: " + result);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static @NotNull String fetchData() throws InterruptedException {
    Thread.sleep(1000);
    return "data";
  }
}
