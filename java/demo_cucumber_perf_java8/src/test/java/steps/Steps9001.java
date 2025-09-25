package steps;

import io.cucumber.java8.En;

public class Steps9001 implements En {

    public Steps9001() {
        When("^the step is implemented9001$", () -> {});
        When("^the step is not implemented yet9001$", () -> {});
        Then("^the next step is executed9001$", () -> {});
        Then("^the next step is skipped9001$", () -> {});
    }
}
