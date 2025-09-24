package steps;

import io.cucumber.java8.En;

public class Steps1543 implements En {

    public Steps1543() {
        When("^the step is implemented1543$", () -> {});
        When("^the step is not implemented yet1543$", () -> {});
        Then("^the next step is executed1543$", () -> {});
        Then("^the next step is skipped1543$", () -> {});
    }
}
