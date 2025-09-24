package steps;

import io.cucumber.java8.En;

public class Steps2001 implements En {

    public Steps2001() {
        When("^the step is implemented2001$", () -> {});
        When("^the step is not implemented yet2001$", () -> {});
        Then("^the next step is executed2001$", () -> {});
        Then("^the next step is skipped2001$", () -> {});
    }
}
