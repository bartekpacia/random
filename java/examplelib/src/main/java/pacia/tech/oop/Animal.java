package pacia.tech.oop;

public class Animal {
  private final String name;

  public Animal(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void makeSound() {
    System.out.println("Some generic animal sound!");
  }
}

class Dog extends Animal {
  public Dog(String name) {
    super(name);
  }

  @Override
  public void makeSound() {
    System.out.println(getName() + " says: Woof!");
  }
}

class Cat extends Animal {
  public Cat(String name) {
    super(name);
  }

  @Override
  public void makeSound() {
    System.out.println(getName() + " says: Meow!");
  }
}