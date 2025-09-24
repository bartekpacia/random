package steps;

import io.cucumber.java8.En;

public class Steps2002 implements En {

    public Steps2002() {
        When("^the step is implemented2002$", () -> {});
        When("^the step is not implemented yet2002$", () -> {});
        Then("^the next step is executed2002$", () -> {});
        Then("^the next step is skipped2002$", () -> {});
    }
}
