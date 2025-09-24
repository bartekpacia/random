package steps;

import io.cucumber.java8.En;

public class Steps2009 implements En {

    public Steps2009() {
        When("^the step is implemented2009$", () -> {});
        When("^the step is not implemented yet2009$", () -> {});
        Then("^the next step is executed2009$", () -> {});
        Then("^the next step is skipped2009$", () -> {});
    }
}
