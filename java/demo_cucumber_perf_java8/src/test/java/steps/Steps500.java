package steps;

import io.cucumber.java8.En;

public class Steps500 implements En {

    public Steps500() {
        When("^the step is implemented500$", () -> {});
        When("^the step is not implemented yet500$", () -> {});
        Then("^the next step is executed500$", () -> {});
        Then("^the next step is skipped500$", () -> {});
    }
}
