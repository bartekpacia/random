package steps;

import io.cucumber.java8.En;

public class Steps8901 implements En {

    public Steps8901() {
        When("^the step is implemented8901$", () -> {});
        When("^the step is not implemented yet8901$", () -> {});
        Then("^the next step is executed8901$", () -> {});
        Then("^the next step is skipped8901$", () -> {});
    }
}
