package steps;

import io.cucumber.java8.En;

public class Steps8700 implements En {

    public Steps8700() {
        When("^the step is implemented8700$", () -> {});
        When("^the step is not implemented yet8700$", () -> {});
        Then("^the next step is executed8700$", () -> {});
        Then("^the next step is skipped8700$", () -> {});
    }
}
