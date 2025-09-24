package steps;

import io.cucumber.java8.En;

public class Steps3150 implements En {

    public Steps3150() {
        When("^the step is implemented3150$", () -> {});
        When("^the step is not implemented yet3150$", () -> {});
        Then("^the next step is executed3150$", () -> {});
        Then("^the next step is skipped3150$", () -> {});
    }
}
