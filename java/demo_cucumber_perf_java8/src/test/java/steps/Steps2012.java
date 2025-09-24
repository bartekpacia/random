package steps;

import io.cucumber.java8.En;

public class Steps2012 implements En {

    public Steps2012() {
        When("^the step is implemented2012$", () -> {});
        When("^the step is not implemented yet2012$", () -> {});
        Then("^the next step is executed2012$", () -> {});
        Then("^the next step is skipped2012$", () -> {});
    }
}
