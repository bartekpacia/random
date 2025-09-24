package steps;

import io.cucumber.java8.En;

public class Steps1203 implements En {

    public Steps1203() {
        When("^the step is implemented1203$", () -> {});
        When("^the step is not implemented yet1203$", () -> {});
        Then("^the next step is executed1203$", () -> {});
        Then("^the next step is skipped1203$", () -> {});
    }
}
