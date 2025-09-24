package steps;

import io.cucumber.java8.En;

public class Steps4001 implements En {

    public Steps4001() {
        When("^the step is implemented4001$", () -> {});
        When("^the step is not implemented yet4001$", () -> {});
        Then("^the next step is executed4001$", () -> {});
        Then("^the next step is skipped4001$", () -> {});
    }
}
