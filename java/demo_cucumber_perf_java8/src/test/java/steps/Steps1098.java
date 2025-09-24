package steps;

import io.cucumber.java8.En;

public class Steps1098 implements En {

    public Steps1098() {
        When("^the step is implemented1098$", () -> {});
        When("^the step is not implemented yet1098$", () -> {});
        Then("^the next step is executed1098$", () -> {});
        Then("^the next step is skipped1098$", () -> {});
    }
}
