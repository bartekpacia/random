package steps;

import io.cucumber.java8.En;

public class Steps1003 implements En {

    public Steps1003() {
        When("^the step is implemented1003$", () -> {});
        When("^the step is not implemented yet1003$", () -> {});
        Then("^the next step is executed1003$", () -> {});
        Then("^the next step is skipped1003$", () -> {});
    }
}
