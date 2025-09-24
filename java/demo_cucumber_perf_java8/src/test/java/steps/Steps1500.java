package steps;

import io.cucumber.java8.En;

public class Steps1500 implements En {

    public Steps1500() {
        When("^the step is implemented1500$", () -> {});
        When("^the step is not implemented yet1500$", () -> {});
        Then("^the next step is executed1500$", () -> {});
        Then("^the next step is skipped1500$", () -> {});
    }
}
