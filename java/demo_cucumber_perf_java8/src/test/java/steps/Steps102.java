package steps;

import io.cucumber.java8.En;

public class Steps102 implements En {

    public Steps102() {
        When("^the step is implemented102$", () -> {});
        When("^the step is not implemented yet102$", () -> {});
        Then("^the next step is executed102$", () -> {});
        Then("^the next step is skipped102$", () -> {});
    }
}
