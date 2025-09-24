package steps;

import io.cucumber.java8.En;

public class Steps1789 implements En {

    public Steps1789() {
        When("^the step is implemented1789$", () -> {});
        When("^the step is not implemented yet1789$", () -> {});
        Then("^the next step is executed1789$", () -> {});
        Then("^the next step is skipped1789$", () -> {});
    }
}
