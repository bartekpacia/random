package steps;

import io.cucumber.java8.En;

public class Steps13 implements En {

    public Steps13() {
        When("^the step is implemented13$", () -> {});
        When("^the step is not implemented yet13$", () -> {});
        Then("^the next step is executed13$", () -> {});
        Then("^the next step is skipped13$", () -> {});
    }
}
