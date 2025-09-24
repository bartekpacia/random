package steps;

import io.cucumber.java8.En;

public class Steps1000 implements En {

    public Steps1000() {
        When("^the step is implemented1000$", () -> {});
        When("^the step is not implemented yet1000$", () -> {});
        Then("^the next step is executed1000$", () -> {});
        Then("^the next step is skipped1000$", () -> {});
    }
}
