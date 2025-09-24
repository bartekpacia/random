package steps;

import io.cucumber.java8.En;

public class Steps3200 implements En {

    public Steps3200() {
        When("^the step is implemented3200$", () -> {});
        When("^the step is not implemented yet3200$", () -> {});
        Then("^the next step is executed3200$", () -> {});
        Then("^the next step is skipped3200$", () -> {});
    }
}
