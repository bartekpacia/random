package steps;

import io.cucumber.java8.En;

public class Steps1303 implements En {

    public Steps1303() {
        When("^the step is implemented1303$", () -> {});
        When("^the step is not implemented yet1303$", () -> {});
        Then("^the next step is executed1303$", () -> {});
        Then("^the next step is skipped1303$", () -> {});
    }
}
