package steps;

import io.cucumber.java8.En;

public class Steps8275 implements En {

    public Steps8275() {
        When("^the step is implemented8275$", () -> {});
        When("^the step is not implemented yet8275$", () -> {});
        Then("^the next step is executed8275$", () -> {});
        Then("^the next step is skipped8275$", () -> {});
    }
}
