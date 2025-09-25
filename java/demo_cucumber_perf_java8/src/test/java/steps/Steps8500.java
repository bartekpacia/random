package steps;

import io.cucumber.java8.En;

public class Steps8500 implements En {

    public Steps8500() {
        When("^the step is implemented8500$", () -> {});
        When("^the step is not implemented yet8500$", () -> {});
        Then("^the next step is executed8500$", () -> {});
        Then("^the next step is skipped8500$", () -> {});
    }
}
