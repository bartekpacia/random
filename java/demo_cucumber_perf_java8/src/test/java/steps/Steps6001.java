package steps;

import io.cucumber.java8.En;

public class Steps6001 implements En {

    public Steps6001() {
        When("^the step is implemented6001$", () -> {});
        When("^the step is not implemented yet6001$", () -> {});
        Then("^the next step is executed6001$", () -> {});
        Then("^the next step is skipped6001$", () -> {});
    }
}
