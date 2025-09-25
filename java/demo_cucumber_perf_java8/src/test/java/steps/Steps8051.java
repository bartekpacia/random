package steps;

import io.cucumber.java8.En;

public class Steps8051 implements En {

    public Steps8051() {
        When("^the step is implemented8051$", () -> {});
        When("^the step is not implemented yet8051$", () -> {});
        Then("^the next step is executed8051$", () -> {});
        Then("^the next step is skipped8051$", () -> {});
    }
}
