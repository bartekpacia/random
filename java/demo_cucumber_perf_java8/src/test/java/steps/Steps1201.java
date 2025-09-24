package steps;

import io.cucumber.java8.En;

public class Steps1201 implements En {

    public Steps1201() {
        When("^the step is implemented1201$", () -> {});
        When("^the step is not implemented yet1201$", () -> {});
        Then("^the next step is executed1201$", () -> {});
        Then("^the next step is skipped1201$", () -> {});
    }
}
