package steps;

import io.cucumber.java8.En;

public class Steps1101 implements En {

    public Steps1101() {
        When("^the step is implemented1101$", () -> {});
        When("^the step is not implemented yet1101$", () -> {});
        Then("^the next step is executed1101$", () -> {});
        Then("^the next step is skipped1101$", () -> {});
    }
}
