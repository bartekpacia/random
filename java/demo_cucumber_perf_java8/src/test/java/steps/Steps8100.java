package steps;

import io.cucumber.java8.En;

public class Steps8100 implements En {

    public Steps8100() {
        When("^the step is implemented8100$", () -> {});
        When("^the step is not implemented yet8100$", () -> {});
        Then("^the next step is executed8100$", () -> {});
        Then("^the next step is skipped8100$", () -> {});
    }
}
