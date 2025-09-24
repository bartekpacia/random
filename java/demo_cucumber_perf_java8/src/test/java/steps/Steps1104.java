package steps;

import io.cucumber.java8.En;

public class Steps1104 implements En {

    public Steps1104() {
        When("^the step is implemented1104$", () -> {});
        When("^the step is not implemented yet1104$", () -> {});
        Then("^the next step is executed1104$", () -> {});
        Then("^the next step is skipped1104$", () -> {});
    }
}
