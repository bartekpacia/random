package steps;

import io.cucumber.java8.En;

public class Steps301 implements En {

    public Steps301() {
        When("^the step is implemented301$", () -> {});
        When("^the step is not implemented yet301$", () -> {});
        Then("^the next step is executed301$", () -> {});
        Then("^the next step is skipped301$", () -> {});
    }
}
