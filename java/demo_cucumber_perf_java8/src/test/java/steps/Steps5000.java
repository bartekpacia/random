package steps;

import io.cucumber.java8.En;

public class Steps5000 implements En {

    public Steps5000() {
        When("^the step is implemented5000$", () -> {});
        When("^the step is not implemented yet5000$", () -> {});
        Then("^the next step is executed5000$", () -> {});
        Then("^the next step is skipped5000$", () -> {});
    }
}
