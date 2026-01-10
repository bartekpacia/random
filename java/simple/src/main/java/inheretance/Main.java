package inheretance;

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

// ---

@FunctionalInterface
interface StringProcessor {
    int process(String s);
}

class Example {
    // Lambda expression - implements StringProcessor
    StringProcessor lambda = s -> s.length();

    // Method reference - ALSO implements StringProcessor!
    StringProcessor methodRef = String::length;

    // Another method reference
    StringProcessor anotherRef = Integer::parseInt;
}