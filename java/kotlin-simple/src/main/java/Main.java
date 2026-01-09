interface Animal {
    String makeSound();
}

abstract class Mammal implements Animal {

}

class Elephant extends Mammal implements Animal {
    @Override
    public String makeSound() {
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
