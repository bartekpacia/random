package steps;

import io.cucumber.java8.En;

public class Steps42 implements En {

    public Steps42() {
        When("^the step is implemented42$", () -> {});
        When("^the step is not implemented yet42$", () -> {});
        Then("^the next step is executed42$", () -> {});
        Then("^the next step is skipped42$", () -> {});
    }
}
