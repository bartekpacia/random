package steps;

import io.cucumber.java8.En;

public class Steps1206 implements En {

    public Steps1206() {
        When("^the step is implemented1206$", () -> {});
        When("^the step is not implemented yet1206$", () -> {});
        Then("^the next step is executed1206$", () -> {});
        Then("^the next step is skipped1206$", () -> {});
    }
}
