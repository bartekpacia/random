package steps;

import io.cucumber.java8.En;

public class Steps2005 implements En {

    public Steps2005() {
        When("^the step is implemented2005$", () -> {});
        When("^the step is not implemented yet2005$", () -> {});
        Then("^the next step is executed2005$", () -> {});
        Then("^the next step is skipped2005$", () -> {});
    }
}
