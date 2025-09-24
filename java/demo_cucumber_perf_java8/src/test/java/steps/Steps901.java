package steps;

import io.cucumber.java8.En;

public class Steps901 implements En {

    public Steps901() {
        When("^the step is implemented901$", () -> {});
        When("^the step is not implemented yet901$", () -> {});
        Then("^the next step is executed901$", () -> {});
        Then("^the next step is skipped901$", () -> {});
    }
}
