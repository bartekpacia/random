package steps;

import io.cucumber.java8.En;

public class Steps8300 implements En {

    public Steps8300() {
        When("^the step is implemented8300$", () -> {});
        When("^the step is not implemented yet8300$", () -> {});
        Then("^the next step is executed8300$", () -> {});
        Then("^the next step is skipped8300$", () -> {});
    }
}
