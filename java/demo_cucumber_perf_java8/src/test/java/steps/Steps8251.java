package steps;

import io.cucumber.java8.En;

public class Steps8251 implements En {

    public Steps8251() {
        When("^the step is implemented8251$", () -> {});
        When("^the step is not implemented yet8251$", () -> {});
        Then("^the next step is executed8251$", () -> {});
        Then("^the next step is skipped8251$", () -> {});
    }
}
