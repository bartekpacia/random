package steps;

import io.cucumber.java8.En;

public class Steps2048 implements En {

    public Steps2048() {
        When("^the step is implemented2048$", () -> {});
        When("^the step is not implemented yet2048$", () -> {});
        Then("^the next step is executed2048$", () -> {});
        Then("^the next step is skipped2048$", () -> {});
    }
}
