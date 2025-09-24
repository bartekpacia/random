package steps;

import io.cucumber.java8.En;

public class Steps1103 implements En {

    public Steps1103() {
        When("^the step is implemented1103$", () -> {});
        When("^the step is not implemented yet1103$", () -> {});
        Then("^the next step is executed1103$", () -> {});
        Then("^the next step is skipped1103$", () -> {});
    }
}
