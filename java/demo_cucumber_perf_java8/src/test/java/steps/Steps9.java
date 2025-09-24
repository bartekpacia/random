package steps;

import io.cucumber.java8.En;

public class Steps9 implements En {

    public Steps9() {
        When("^the step is implemented9$", () -> {});
        When("^the step is not implemented yet9$", () -> {});
        Then("^the next step is executed9$", () -> {});
        Then("^the next step is skipped9$", () -> {});
    }
}
