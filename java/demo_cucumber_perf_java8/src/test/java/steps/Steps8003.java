package steps;

import io.cucumber.java8.En;

public class Steps8003 implements En {

    public Steps8003() {
        When("^the step is implemented8003$", () -> {});
        When("^the step is not implemented yet8003$", () -> {});
        Then("^the next step is executed8003$", () -> {});
        Then("^the next step is skipped8003$", () -> {});
    }
}
