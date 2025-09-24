package steps;

import io.cucumber.java8.En;

public class Steps3048 implements En {

    public Steps3048() {
        When("^the step is implemented3048$", () -> {});
        When("^the step is not implemented yet3048$", () -> {});
        Then("^the next step is executed3048$", () -> {});
        Then("^the next step is skipped3048$", () -> {});
    }
}
