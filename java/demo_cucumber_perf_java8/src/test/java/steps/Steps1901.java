package steps;

import io.cucumber.java8.En;

public class Steps1901 implements En {

    public Steps1901() {
        When("^the step is implemented1901$", () -> {});
        When("^the step is not implemented yet1901$", () -> {});
        Then("^the next step is executed1901$", () -> {});
        Then("^the next step is skipped1901$", () -> {});
    }
}
