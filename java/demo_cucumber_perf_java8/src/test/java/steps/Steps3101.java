package steps;

import io.cucumber.java8.En;

public class Steps3101 implements En {

    public Steps3101() {
        When("^the step is implemented3101$", () -> {});
        When("^the step is not implemented yet3101$", () -> {});
        Then("^the next step is executed3101$", () -> {});
        Then("^the next step is skipped3101$", () -> {});
    }
}
