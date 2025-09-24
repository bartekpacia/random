package steps;

import io.cucumber.java8.En;

public class Steps2000 implements En {

    public Steps2000() {
        When("^the step is implemented2000$", () -> {});
        When("^the step is not implemented yet2000$", () -> {});
        Then("^the next step is executed2000$", () -> {});
        Then("^the next step is skipped2000$", () -> {});
    }
}
