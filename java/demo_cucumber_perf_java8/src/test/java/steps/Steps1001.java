package steps;

import io.cucumber.java8.En;

public class Steps1001 implements En {

    public Steps1001() {
        When("^the step is implemented1001$", () -> {});
        When("^the step is not implemented yet1001$", () -> {});
        Then("^the next step is executed1001$", () -> {});
        Then("^the next step is skipped1001$", () -> {});
    }
}
