package steps;

import io.cucumber.java8.En;

public class Steps8002 implements En {

    public Steps8002() {
        When("^the step is implemented8002$", () -> {});
        When("^the step is not implemented yet8002$", () -> {});
        Then("^the next step is executed8002$", () -> {});
        Then("^the next step is skipped8002$", () -> {});
    }
}
