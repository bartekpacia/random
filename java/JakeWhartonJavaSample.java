import java.time.*;

class JakeWhartonJavaSample {
  interface Logger {
    void log(LocalDateTime time, String s);
  }

  public static void main(String... args) {
    sayHi((time, s) -> System.out.println(time + " " + s));
  }

  private static void sayHi(Logger logger) {
    logger.log(LocalDateTime.now(), "Hello!");
  }
}
