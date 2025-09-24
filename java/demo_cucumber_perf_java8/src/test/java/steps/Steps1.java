package steps;

import io.cucumber.java8.En;

public class Steps1 implements En {

    public Steps1() {
        When("^the step is implemented1$", () -> {});
        When("^the step is not implemented yet1$", () -> {});
        Then("^the next step is executed1$", () -> {});
        Then("^the next step is skipped1$", () -> {});
    }
}
