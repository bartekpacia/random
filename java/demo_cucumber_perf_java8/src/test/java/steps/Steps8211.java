package steps;

import io.cucumber.java8.En;

public class Steps8211 implements En {

    public Steps8211() {
        When("^the step is implemented8211$", () -> {});
        When("^the step is not implemented yet8211$", () -> {});
        Then("^the next step is executed8211$", () -> {});
        Then("^the next step is skipped8211$", () -> {});
    }
}
