package steps;

import io.cucumber.java8.En;

public class Steps3001 implements En {

    public Steps3001() {
        When("^the step is implemented3001$", () -> {});
        When("^the step is not implemented yet3001$", () -> {});
        Then("^the next step is executed3001$", () -> {});
        Then("^the next step is skipped3001$", () -> {});
    }
}
