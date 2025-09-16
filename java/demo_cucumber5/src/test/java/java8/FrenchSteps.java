package java8;

import io.cucumber.java8.Cs;
import io.cucumber.java8.Fr;

public class FrenchSteps implements Fr, Cs {
    public FrenchSteps() {
        Quand("simple", () -> {
        });

        Etantdonnéque("complex", () -> {
        });

        Ataké("simple_czech", () -> {});
    }
}
