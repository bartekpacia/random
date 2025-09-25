package steps;

import io.cucumber.java8.En;

public class Steps5002 implements En {

    public Steps5002() {
        When("^the step is implemented5002$", () -> {});
        When("^the step is not implemented yet5002$", () -> {});
        Then("^the next step is executed5002$", () -> {});
        Then("^the next step is skipped5002$", () -> {});
    }
}
