package steps;

import io.cucumber.java8.En;

public class Steps3300 implements En {

    public Steps3300() {
        When("^the step is implemented3300$", () -> {});
        When("^the step is not implemented yet3300$", () -> {});
        Then("^the next step is executed3300$", () -> {});
        Then("^the next step is skipped3300$", () -> {});
    }
}
