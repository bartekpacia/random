package steps;

import io.cucumber.java8.En;

public class Steps8086 implements En {

    public Steps8086() {
        When("^the step is implemented8086$", () -> {});
        When("^the step is not implemented yet8086$", () -> {});
        Then("^the next step is executed8086$", () -> {});
        Then("^the next step is skipped8086$", () -> {});
    }
}
