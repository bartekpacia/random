package simple4;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");

        Thread t = new Thread(() -> {

        });
        t.start();
    }
}
