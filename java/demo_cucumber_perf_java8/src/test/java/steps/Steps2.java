package steps;

import io.cucumber.java8.En;

public class Steps2 implements En {

    public Steps2() {
        When("^the step is implemented2$", () -> {});
        When("^the step is not implemented yet2$", () -> {});
        Then("^the next step is executed2$", () -> {});
        Then("^the next step is skipped2$", () -> {});
    }
}
