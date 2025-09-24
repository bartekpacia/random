package steps;

import io.cucumber.java8.En;

public class Steps2010 implements En {

    public Steps2010() {
        When("^the step is implemented2010$", () -> {});
        When("^the step is not implemented yet2010$", () -> {});
        Then("^the next step is executed2010$", () -> {});
        Then("^the next step is skipped2010$", () -> {});
    }
}
