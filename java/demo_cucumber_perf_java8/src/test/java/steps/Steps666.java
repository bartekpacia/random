package steps;

import io.cucumber.java8.En;

public class Steps666 implements En {

    public Steps666() {
        When("^the step is implemented666$", () -> {});
        When("^the step is not implemented yet666$", () -> {});
        Then("^the next step is executed666$", () -> {});
        Then("^the next step is skipped666$", () -> {});
    }
}
