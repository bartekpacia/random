package steps;

import io.cucumber.java8.En;

public class Steps3601 implements En {

    public Steps3601() {
        When("^the step is implemented3601$", () -> {});
        When("^the step is not implemented yet3601$", () -> {});
        Then("^the next step is executed3601$", () -> {});
        Then("^the next step is skipped3601$", () -> {});
    }
}
