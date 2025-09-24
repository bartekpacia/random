package steps;

import io.cucumber.java8.En;

public class Steps400 implements En {

    public Steps400() {
        When("^the step is implemented400$", () -> {});
        When("^the step is not implemented yet400$", () -> {});
        Then("^the next step is executed400$", () -> {});
        Then("^the next step is skipped400$", () -> {});
    }
}
