package steps;

import io.cucumber.java8.En;

public class Steps8601 implements En {

    public Steps8601() {
        When("^the step is implemented8601$", () -> {});
        When("^the step is not implemented yet8601$", () -> {});
        Then("^the next step is executed8601$", () -> {});
        Then("^the next step is skipped8601$", () -> {});
    }
}
