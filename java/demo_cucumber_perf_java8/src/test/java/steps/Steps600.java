package steps;

import io.cucumber.java8.En;

public class Steps600 implements En {

    public Steps600() {
        When("^the step is implemented600$", () -> {});
        When("^the step is not implemented yet600$", () -> {});
        Then("^the next step is executed600$", () -> {});
        Then("^the next step is skipped600$", () -> {});
    }
}
