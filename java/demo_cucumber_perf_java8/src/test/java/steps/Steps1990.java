package steps;

import io.cucumber.java8.En;

public class Steps1990 implements En {

    public Steps1990() {
        When("^the step is implemented1990$", () -> {});
        When("^the step is not implemented yet1990$", () -> {});
        Then("^the next step is executed1990$", () -> {});
        Then("^the next step is skipped1990$", () -> {});
    }
}
