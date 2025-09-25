package steps;

import io.cucumber.java8.En;

public class Steps9042 implements En {

    public Steps9042() {
        When("^the step is implemented9042$", () -> {});
        When("^the step is not implemented yet9042$", () -> {});
        Then("^the next step is executed9042$", () -> {});
        Then("^the next step is skipped9042$", () -> {});
    }
}
