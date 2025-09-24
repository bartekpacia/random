package steps;

import io.cucumber.java8.En;

public class Steps1903 implements En {

    public Steps1903() {
        When("^the step is implemented1903$", () -> {});
        When("^the step is not implemented yet1903$", () -> {});
        Then("^the next step is executed1903$", () -> {});
        Then("^the next step is skipped1903$", () -> {});
    }
}
