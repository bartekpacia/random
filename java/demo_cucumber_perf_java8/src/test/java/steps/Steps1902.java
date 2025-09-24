package steps;

import io.cucumber.java8.En;

public class Steps1902 implements En {

    public Steps1902() {
        When("^the step is implemented1902$", () -> {});
        When("^the step is not implemented yet1902$", () -> {});
        Then("^the next step is executed1902$", () -> {});
        Then("^the next step is skipped1902$", () -> {});
    }
}
