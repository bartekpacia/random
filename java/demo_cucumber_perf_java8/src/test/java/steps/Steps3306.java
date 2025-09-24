package steps;

import io.cucumber.java8.En;

public class Steps3306 implements En {

    public Steps3306() {
        When("^the step is implemented3306$", () -> {});
        When("^the step is not implemented yet3306$", () -> {});
        Then("^the next step is executed3306$", () -> {});
        Then("^the next step is skipped3306$", () -> {});
    }
}
