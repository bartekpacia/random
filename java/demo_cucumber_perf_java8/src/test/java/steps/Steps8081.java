package steps;

import io.cucumber.java8.En;

public class Steps8081 implements En {

    public Steps8081() {
        When("^the step is implemented8081$", () -> {});
        When("^the step is not implemented yet8081$", () -> {});
        Then("^the next step is executed8081$", () -> {});
        Then("^the next step is skipped8081$", () -> {});
    }
}
