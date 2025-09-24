package steps;

import io.cucumber.java8.En;

public class Steps3080 implements En {

    public Steps3080() {
        When("^the step is implemented3080$", () -> {});
        When("^the step is not implemented yet3080$", () -> {});
        Then("^the next step is executed3080$", () -> {});
        Then("^the next step is skipped3080$", () -> {});
    }
}
