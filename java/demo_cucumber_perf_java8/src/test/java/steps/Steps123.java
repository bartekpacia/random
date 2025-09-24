package steps;

import io.cucumber.java8.En;

public class Steps123 implements En {

    public Steps123() {
        When("^the step is implemented123$", () -> {});
        When("^the step is not implemented yet123$", () -> {});
        Then("^the next step is executed123$", () -> {});
        Then("^the next step is skipped123$", () -> {});
    }
}
