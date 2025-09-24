package steps;

import io.cucumber.java8.En;

public class Steps3500 implements En {

    public Steps3500() {
        When("^the step is implemented3500$", () -> {});
        When("^the step is not implemented yet3500$", () -> {});
        Then("^the next step is executed3500$", () -> {});
        Then("^the next step is skipped3500$", () -> {});
    }
}
