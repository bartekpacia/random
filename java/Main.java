public class Main {
    public class Nested {
        public static void main(String[] args) {
            System.out.printf("Hello and welcome!");
            for (int i = 1; i <= 5; i++) {
                System.out.println("i = " + i);
                int a = i + 1;
                System.out.println(a);
            }
            return;
        }
    }
}
