package steps;

import io.cucumber.java8.En;

public class Steps1005 implements En {

    public Steps1005() {
        When("^the step is implemented1005$", () -> {});
        When("^the step is not implemented yet1005$", () -> {});
        Then("^the next step is executed1005$", () -> {});
        Then("^the next step is skipped1005$", () -> {});
    }
}
