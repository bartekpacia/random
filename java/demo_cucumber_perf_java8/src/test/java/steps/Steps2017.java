package steps;

import io.cucumber.java8.En;

public class Steps2017 implements En {

    public Steps2017() {
        When("^the step is implemented2017$", () -> {});
        When("^the step is not implemented yet2017$", () -> {});
        Then("^the next step is executed2017$", () -> {});
        Then("^the next step is skipped2017$", () -> {});
    }
}
