package steps;

import io.cucumber.java8.En;

public class Steps8001 implements En {

    public Steps8001() {
        When("^the step is implemented8001$", () -> {});
        When("^the step is not implemented yet8001$", () -> {});
        Then("^the next step is executed8001$", () -> {});
        Then("^the next step is skipped8001$", () -> {});
    }
}
