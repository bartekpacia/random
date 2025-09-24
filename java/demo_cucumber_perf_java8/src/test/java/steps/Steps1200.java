package steps;

import io.cucumber.java8.En;

public class Steps1200 implements En {

    public Steps1200() {
        When("^the step is implemented1200$", () -> {});
        When("^the step is not implemented yet1200$", () -> {});
        Then("^the next step is executed1200$", () -> {});
        Then("^the next step is skipped1200$", () -> {});
    }
}
