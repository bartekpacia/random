package steps;

import io.cucumber.java8.En;

public class Steps2003 implements En {

    public Steps2003() {
        When("^the step is implemented2003$", () -> {});
        When("^the step is not implemented yet2003$", () -> {});
        Then("^the next step is executed2003$", () -> {});
        Then("^the next step is skipped2003$", () -> {});
    }
}
