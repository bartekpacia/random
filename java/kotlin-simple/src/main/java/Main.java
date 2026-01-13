interface Animal {
    String makeSound();
}

class Dog implements Animal {

    @Override
    public String makeSound() {
        return "woof woof";
    }
}

public class Main {
    static void main(String[] args) {
        new Object() {
            void foo() {
                class Fish implements Animal {
                    @Override
                    public String makeSound() {
                        return "<no idea what sound a fish makes>";
                    }
                }

                Animal b = () -> "meow meow";
                b.makeSound();
            }
        };
    }
}
