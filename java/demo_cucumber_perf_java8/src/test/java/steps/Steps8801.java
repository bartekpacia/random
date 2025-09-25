package steps;

import io.cucumber.java8.En;

public class Steps8801 implements En {

    public Steps8801() {
        When("^the step is implemented8801$", () -> {});
        When("^the step is not implemented yet8801$", () -> {});
        Then("^the next step is executed8801$", () -> {});
        Then("^the next step is skipped8801$", () -> {});
    }
}
