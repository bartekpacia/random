package steps;

import io.cucumber.java8.En;

public class Steps8000 implements En {

    public Steps8000() {
        When("^the step is implemented8000$", () -> {});
        When("^the step is not implemented yet8000$", () -> {});
        Then("^the next step is executed8000$", () -> {});
        Then("^the next step is skipped8000$", () -> {});
    }
}
