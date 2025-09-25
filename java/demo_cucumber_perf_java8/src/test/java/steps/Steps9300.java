package steps;

import io.cucumber.java8.En;

public class Steps9300 implements En {

    public Steps9300() {
        When("^the step is implemented9300$", () -> {});
        When("^the step is not implemented yet9300$", () -> {});
        Then("^the next step is executed9300$", () -> {});
        Then("^the next step is skipped9300$", () -> {});
    }
}
