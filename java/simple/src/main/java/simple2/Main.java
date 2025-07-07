package simple2;

import java.util.List;
import java.util.concurrent.Semaphore;

// problems: (1) not possible to move tabs  (2) respect file name extension setting
// TODO: ask #ij-ui
public class Main {
    public static String name = "Charlie";
    public static Object obj = new Object();

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");

        List<String> list = List.of();
        list.stream().map((a) -> {
            return a.toLowerCase();
        });
    }
}
