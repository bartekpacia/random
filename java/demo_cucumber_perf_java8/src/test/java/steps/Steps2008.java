package steps;

import io.cucumber.java8.En;

public class Steps2008 implements En {

    public Steps2008() {
        When("^the step is implemented2008$", () -> {});
        When("^the step is not implemented yet2008$", () -> {});
        Then("^the next step is executed2008$", () -> {});
        Then("^the next step is skipped2008$", () -> {});
    }
}
