interface Animal {
    makeSound(): string;
}

abstract class Mammal implements Animal {
    abstract makeSound(): string;
}

class Elephant extends Mammal implements Animal {
    makeSound(): string {
        const a: Animal = { makeSound: () => "xd" };
        return "Trumpet!";
    }
}

class Dodo extends Mammal implements Animal {
    makeSound(): string {
        return "???";
    }
}
