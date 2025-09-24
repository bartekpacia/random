package steps;

import io.cucumber.java8.En;

public class Steps900 implements En {

    public Steps900() {
        When("^the step is implemented900$", () -> {});
        When("^the step is not implemented yet900$", () -> {});
        Then("^the next step is executed900$", () -> {});
        Then("^the next step is skipped900$", () -> {});
    }
}
