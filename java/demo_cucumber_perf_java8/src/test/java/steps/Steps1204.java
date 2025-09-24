package steps;

import io.cucumber.java8.En;

public class Steps1204 implements En {

    public Steps1204() {
        When("^the step is implemented1204$", () -> {});
        When("^the step is not implemented yet1204$", () -> {});
        Then("^the next step is executed1204$", () -> {});
        Then("^the next step is skipped1204$", () -> {});
    }
}
