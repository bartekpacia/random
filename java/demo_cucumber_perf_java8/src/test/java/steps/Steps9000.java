package steps;

import io.cucumber.java8.En;

public class Steps9000 implements En {

    public Steps9000() {
        When("^the step is implemented9000$", () -> {});
        When("^the step is not implemented yet9000$", () -> {});
        Then("^the next step is executed9000$", () -> {});
        Then("^the next step is skipped9000$", () -> {});
    }
}
