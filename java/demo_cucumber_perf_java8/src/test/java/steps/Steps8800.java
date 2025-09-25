package steps;

import io.cucumber.java8.En;

public class Steps8800 implements En {

    public Steps8800() {
        When("^the step is implemented8800$", () -> {});
        When("^the step is not implemented yet8800$", () -> {});
        Then("^the next step is executed8800$", () -> {});
        Then("^the next step is skipped8800$", () -> {});
    }
}
