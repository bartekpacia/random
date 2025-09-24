package steps;

import io.cucumber.java8.En;

public class Steps1106 implements En {

    public Steps1106() {
        When("^the step is implemented1106$", () -> {});
        When("^the step is not implemented yet1106$", () -> {});
        Then("^the next step is executed1106$", () -> {});
        Then("^the next step is skipped1106$", () -> {});
    }
}
