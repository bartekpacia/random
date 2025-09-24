package steps;

import io.cucumber.java8.En;

public class Steps2345 implements En {

    public Steps2345() {
        When("^the step is implemented2345$", () -> {});
        When("^the step is not implemented yet2345$", () -> {});
        Then("^the next step is executed2345$", () -> {});
        Then("^the next step is skipped2345$", () -> {});
    }
}
