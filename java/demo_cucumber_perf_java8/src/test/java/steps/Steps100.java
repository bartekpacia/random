package steps;

import io.cucumber.java8.En;

public class Steps100 implements En {

    public Steps100() {
        When("^the step is implemented100$", () -> {});
        When("^the step is not implemented yet100$", () -> {});
        Then("^the next step is executed100$", () -> {});
        Then("^the next step is skipped100$", () -> {});
    }
}
