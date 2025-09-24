package steps;

import io.cucumber.java8.En;

public class Steps1900 implements En {

    public Steps1900() {
        When("^the step is implemented1900$", () -> {});
        When("^the step is not implemented yet1900$", () -> {});
        Then("^the next step is executed1900$", () -> {});
        Then("^the next step is skipped1900$", () -> {});
    }
}
