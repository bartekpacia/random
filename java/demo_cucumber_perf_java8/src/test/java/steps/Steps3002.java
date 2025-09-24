package steps;

import io.cucumber.java8.En;

public class Steps3002 implements En {

    public Steps3002() {
        When("^the step is implemented3002$", () -> {});
        When("^the step is not implemented yet3002$", () -> {});
        Then("^the next step is executed3002$", () -> {});
        Then("^the next step is skipped3002$", () -> {});
    }
}
