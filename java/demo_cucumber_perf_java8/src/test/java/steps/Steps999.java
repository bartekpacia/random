package steps;

import io.cucumber.java8.En;

public class Steps999 implements En {

    public Steps999() {
        When("^the step is implemented999$", () -> {});
        When("^the step is not implemented yet999$", () -> {});
        Then("^the next step is executed999$", () -> {});
        Then("^the next step is skipped999$", () -> {});
    }
}
