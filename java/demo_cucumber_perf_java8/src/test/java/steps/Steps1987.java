package steps;

import io.cucumber.java8.En;

public class Steps1987 implements En {

    public Steps1987() {
        When("^the step is implemented1987$", () -> {});
        When("^the step is not implemented yet1987$", () -> {});
        Then("^the next step is executed1987$", () -> {});
        Then("^the next step is skipped1987$", () -> {});
    }
}
