package steps;

import io.cucumber.java8.En;

public class Steps8080 implements En {

    public Steps8080() {
        When("^the step is implemented8080$", () -> {});
        When("^the step is not implemented yet8080$", () -> {});
        Then("^the next step is executed8080$", () -> {});
        Then("^the next step is skipped8080$", () -> {});
    }
}
