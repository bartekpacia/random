package steps;

import io.cucumber.java8.En;

public class Steps8 implements En {

    public Steps8() {
        When("^the step is implemented8$", () -> {});
        When("^the step is not implemented yet8$", () -> {});
        Then("^the next step is executed8$", () -> {});
        Then("^the next step is skipped8$", () -> {});
    }
}
