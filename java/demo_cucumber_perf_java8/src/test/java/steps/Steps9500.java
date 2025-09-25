package steps;

import io.cucumber.java8.En;

public class Steps9500 implements En {

    public Steps9500() {
        When("^the step is implemented9500$", () -> {});
        When("^the step is not implemented yet9500$", () -> {});
        Then("^the next step is executed9500$", () -> {});
        Then("^the next step is skipped9500$", () -> {});
    }
}
