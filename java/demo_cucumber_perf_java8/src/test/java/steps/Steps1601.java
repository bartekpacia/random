package steps;

import io.cucumber.java8.En;

public class Steps1601 implements En {

    public Steps1601() {
        When("^the step is implemented1601$", () -> {});
        When("^the step is not implemented yet1601$", () -> {});
        Then("^the next step is executed1601$", () -> {});
        Then("^the next step is skipped1601$", () -> {});
    }
}
