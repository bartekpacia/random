package steps;

import io.cucumber.java8.En;

public class Steps1123 implements En {

    public Steps1123() {
        When("^the step is implemented1123$", () -> {});
        When("^the step is not implemented yet1123$", () -> {});
        Then("^the next step is executed1123$", () -> {});
        Then("^the next step is skipped1123$", () -> {});
    }
}
