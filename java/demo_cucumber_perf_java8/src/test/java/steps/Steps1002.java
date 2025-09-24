package steps;

import io.cucumber.java8.En;

public class Steps1002 implements En {

    public Steps1002() {
        When("^the step is implemented1002$", () -> {});
        When("^the step is not implemented yet1002$", () -> {});
        Then("^the next step is executed1002$", () -> {});
        Then("^the next step is skipped1002$", () -> {});
    }
}
