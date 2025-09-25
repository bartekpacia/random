package steps;

import io.cucumber.java8.En;

public class Steps8200 implements En {

    public Steps8200() {
        When("^the step is implemented8200$", () -> {});
        When("^the step is not implemented yet8200$", () -> {});
        Then("^the next step is executed8200$", () -> {});
        Then("^the next step is skipped8200$", () -> {});
    }
}
