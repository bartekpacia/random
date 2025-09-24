package steps;

import io.cucumber.java8.En;

public class Steps12 implements En {

    public Steps12() {
        When("^the step is implemented12$", () -> {});
        When("^the step is not implemented yet12$", () -> {});
        Then("^the next step is executed12$", () -> {});
        Then("^the next step is skipped12$", () -> {});
    }
}
