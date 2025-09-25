package steps;

import io.cucumber.java8.En;

public class Steps6502 implements En {

    public Steps6502() {
        When("^the step is implemented6502$", () -> {});
        When("^the step is not implemented yet6502$", () -> {});
        Then("^the next step is executed6502$", () -> {});
        Then("^the next step is skipped6502$", () -> {});
    }
}
