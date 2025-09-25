package steps;

import io.cucumber.java8.En;

public class Steps5001 implements En {

    public Steps5001() {
        When("^the step is implemented5001$", () -> {});
        When("^the step is not implemented yet5001$", () -> {});
        Then("^the next step is executed5001$", () -> {});
        Then("^the next step is skipped5001$", () -> {});
    }
}
