package steps;

import io.cucumber.java8.En;

public class Steps1234 implements En {

    public Steps1234() {
        When("^the step is implemented1234$", () -> {});
        When("^the step is not implemented yet1234$", () -> {});
        Then("^the next step is executed1234$", () -> {});
        Then("^the next step is skipped1234$", () -> {});
    }
}
