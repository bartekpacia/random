package steps;

import io.cucumber.java8.En;

public class Steps300 implements En {

    public Steps300() {
        When("^the step is implemented300$", () -> {});
        When("^the step is not implemented yet300$", () -> {});
        Then("^the next step is executed300$", () -> {});
        Then("^the next step is skipped300$", () -> {});
    }
}
