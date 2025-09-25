package steps;

import io.cucumber.java8.En;

public class Steps8400 implements En {

    public Steps8400() {
        When("^the step is implemented8400$", () -> {});
        When("^the step is not implemented yet8400$", () -> {});
        Then("^the next step is executed8400$", () -> {});
        Then("^the next step is skipped8400$", () -> {});
    }
}
