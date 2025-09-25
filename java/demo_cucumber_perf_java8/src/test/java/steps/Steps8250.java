package steps;

import io.cucumber.java8.En;

public class Steps8250 implements En {

    public Steps8250() {
        When("^the step is implemented8250$", () -> {});
        When("^the step is not implemented yet8250$", () -> {});
        Then("^the next step is executed8250$", () -> {});
        Then("^the next step is skipped8250$", () -> {});
    }
}
