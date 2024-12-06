import org.jetbrains.annotations.NotNull;

public class ExampleLib {
  // Return `num` incremented by 10.
  public int myLibraryFunc(int num) {
    int result = num;
    int firstIncrement = 5;
    result += firstIncrement;
    int secondIncrement = 5;
    result += secondIncrement;
    assert (firstIncrement + secondIncrement == 10);
    return result;
  }

  public class NestedInnerClass {
    public void foo() {
    }
  }

  public static class NestedStaticClass {
    public @NotNull Boolean foo(@NotNull String bar) {
      String baz = "baz" + bar;
      return "match".equals(baz);
    }
  }
}
