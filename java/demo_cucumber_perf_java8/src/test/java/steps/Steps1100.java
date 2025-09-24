package steps;

import io.cucumber.java8.En;

public class Steps1100 implements En {

    public Steps1100() {
        When("^the step is implemented1100$", () -> {});
        When("^the step is not implemented yet1100$", () -> {});
        Then("^the next step is executed1100$", () -> {});
        Then("^the next step is skipped1100$", () -> {});
    }
}
