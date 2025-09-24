package steps;

import io.cucumber.java8.En;

public class Steps2007 implements En {

    public Steps2007() {
        When("^the step is implemented2007$", () -> {});
        When("^the step is not implemented yet2007$", () -> {});
        Then("^the next step is executed2007$", () -> {});
        Then("^the next step is skipped2007$", () -> {});
    }
}
