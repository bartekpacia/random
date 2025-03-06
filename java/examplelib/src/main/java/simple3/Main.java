package simple3;

public class Main {
  private static int foo;

  public Main() {
    System.out.println("Created!");
    incrementInt(incrementInt(incrementInt(foo)));
  }

  public static void main(String[] args) {
    System.out.println("foo is: " + foo);
  }

  public int incrementInt(int input) {
    return input + 1;
  }
}