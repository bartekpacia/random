import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample3 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable task1 = new Runnable() {
            public void run() {
                System.out.println("Task 1!");
            }
        };

        Runnable task2 = new Runnable() {
            public void run() {
                System.out.println("Task 2!");
            }
        };

        executor.execute(task1);
        executor.execute(task2);
        executor.shutdown(); // shut down the executor
    }
}
