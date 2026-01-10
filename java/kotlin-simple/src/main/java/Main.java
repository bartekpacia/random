interface Animal {
    String makeSound();
}

abstract class Mammal implements Animal {

}

class Elephant extends Mammal implements Animal {
    @Override
    public String makeSound() {
        JavaClass javClass = new JavaClass();
        Animal a = () -> "xd";
        return "Trumpet!";
    }
}

class Dodo extends Mammal implements Animal {
    @Override
    public String makeSound() {
        return "???";
    }
}
