package steps;

import io.cucumber.java8.En;

public class Steps3141 implements En {

    public Steps3141() {
        When("^the step is implemented3141$", () -> {});
        When("^the step is not implemented yet3141$", () -> {});
        Then("^the next step is executed3141$", () -> {});
        Then("^the next step is skipped3141$", () -> {});
    }
}
