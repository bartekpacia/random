package steps;

import io.cucumber.java8.En;

public class Steps99 implements En {

    public Steps99() {
        When("^the step is implemented99$", () -> {});
        When("^the step is not implemented yet99$", () -> {});
        Then("^the next step is executed99$", () -> {});
        Then("^the next step is skipped99$", () -> {});
    }
}
