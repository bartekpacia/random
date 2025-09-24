package steps;

import io.cucumber.java8.En;

public class Steps1202 implements En {

    public Steps1202() {
        When("^the step is implemented1202$", () -> {});
        When("^the step is not implemented yet1202$", () -> {});
        Then("^the next step is executed1202$", () -> {});
        Then("^the next step is skipped1202$", () -> {});
    }
}
