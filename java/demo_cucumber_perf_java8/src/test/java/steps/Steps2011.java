package steps;

import io.cucumber.java8.En;

public class Steps2011 implements En {

    public Steps2011() {
        When("^the step is implemented2011$", () -> {});
        When("^the step is not implemented yet2011$", () -> {});
        Then("^the next step is executed2011$", () -> {});
        Then("^the next step is skipped2011$", () -> {});
    }
}
