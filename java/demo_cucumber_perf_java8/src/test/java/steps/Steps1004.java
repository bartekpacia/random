package steps;

import io.cucumber.java8.En;

public class Steps1004 implements En {

    public Steps1004() {
        When("^the step is implemented1004$", () -> {});
        When("^the step is not implemented yet1004$", () -> {});
        Then("^the next step is executed1004$", () -> {});
        Then("^the next step is skipped1004$", () -> {});
    }
}
