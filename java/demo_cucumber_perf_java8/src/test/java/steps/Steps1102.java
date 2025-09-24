package steps;

import io.cucumber.java8.En;

public class Steps1102 implements En {

    public Steps1102() {
        When("^the step is implemented1102$", () -> {});
        When("^the step is not implemented yet1102$", () -> {});
        Then("^the next step is executed1102$", () -> {});
        Then("^the next step is skipped1102$", () -> {});
    }
}
