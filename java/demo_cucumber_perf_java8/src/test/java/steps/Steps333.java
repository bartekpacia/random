package steps;

import io.cucumber.java8.En;

public class Steps333 implements En {

    public Steps333() {
        When("^the step is implemented333$", () -> {});
        When("^the step is not implemented yet333$", () -> {});
        Then("^the next step is executed333$", () -> {});
        Then("^the next step is skipped333$", () -> {});
    }
}
