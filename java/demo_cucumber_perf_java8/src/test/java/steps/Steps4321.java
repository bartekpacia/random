package steps;

import io.cucumber.java8.En;

public class Steps4321 implements En {

    public Steps4321() {
        When("^the step is implemented4321$", () -> {});
        When("^the step is not implemented yet4321$", () -> {});
        Then("^the next step is executed4321$", () -> {});
        Then("^the next step is skipped4321$", () -> {});
    }
}
