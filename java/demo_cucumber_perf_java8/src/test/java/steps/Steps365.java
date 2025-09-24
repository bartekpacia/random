package steps;

import io.cucumber.java8.En;

public class Steps365 implements En {

    public Steps365() {
        When("^the step is implemented365$", () -> {});
        When("^the step is not implemented yet365$", () -> {});
        Then("^the next step is executed365$", () -> {});
        Then("^the next step is skipped365$", () -> {});
    }
}
