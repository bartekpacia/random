package steps;

import io.cucumber.java8.En;

public class Steps3000 implements En {

    public Steps3000() {
        When("^the step is implemented3000$", () -> {});
        When("^the step is not implemented yet3000$", () -> {});
        Then("^the next step is executed3000$", () -> {});
        Then("^the next step is skipped3000$", () -> {});
    }
}
