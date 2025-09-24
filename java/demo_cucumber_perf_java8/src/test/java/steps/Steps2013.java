package steps;

import io.cucumber.java8.En;

public class Steps2013 implements En {

    public Steps2013() {
        When("^the step is implemented2013$", () -> {});
        When("^the step is not implemented yet2013$", () -> {});
        Then("^the next step is executed2013$", () -> {});
        Then("^the next step is skipped2013$", () -> {});
    }
}
