package steps;

import io.cucumber.java8.En;

public class Steps303 implements En {

    public Steps303() {
        When("^the step is implemented303$", () -> {});
        When("^the step is not implemented yet303$", () -> {});
        Then("^the next step is executed303$", () -> {});
        Then("^the next step is skipped303$", () -> {});
    }
}
