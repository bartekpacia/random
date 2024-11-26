import java.util.List;

public record ExampleComplexRecord(String name, int age, List<String> favoriteCars) {
  public ExampleComplexRecord {
    favoriteCars = List.copyOf(favoriteCars);
  }

  public void print() {
    System.out.println("favoriteCars = " + favoriteCars);
  }
}
