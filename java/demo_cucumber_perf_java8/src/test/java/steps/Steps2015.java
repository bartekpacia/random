package steps;

import io.cucumber.java8.En;

public class Steps2015 implements En {

    public Steps2015() {
        When("^the step is implemented2015$", () -> {});
        When("^the step is not implemented yet2015$", () -> {});
        Then("^the next step is executed2015$", () -> {});
        Then("^the next step is skipped2015$", () -> {});
    }
}
