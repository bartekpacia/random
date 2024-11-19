package pacia.tech;

import java.util.List;

public record ExampleRecord(String name, int age, List<String> favoriteCars) {
  public ExampleRecord {
    favoriteCars = List.copyOf(favoriteCars);
  }

  public void print() {
    System.out.println("favoriteCars = " + favoriteCars);
  }
}
