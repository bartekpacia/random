package steps;

import io.cucumber.java8.En;

public class Steps1105 implements En {

    public Steps1105() {
        When("^the step is implemented1105$", () -> {});
        When("^the step is not implemented yet1105$", () -> {});
        Then("^the next step is executed1105$", () -> {});
        Then("^the next step is skipped1105$", () -> {});
    }
}
