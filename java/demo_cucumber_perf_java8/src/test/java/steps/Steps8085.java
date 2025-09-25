package steps;

import io.cucumber.java8.En;

public class Steps8085 implements En {

    public Steps8085() {
        When("^the step is implemented8085$", () -> {});
        When("^the step is not implemented yet8085$", () -> {});
        Then("^the next step is executed8085$", () -> {});
        Then("^the next step is skipped8085$", () -> {});
    }
}
