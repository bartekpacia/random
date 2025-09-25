package steps;

import io.cucumber.java8.En;

public class Steps8212 implements En {

    public Steps8212() {
        When("^the step is implemented8212$", () -> {});
        When("^the step is not implemented yet8212$", () -> {});
        Then("^the next step is executed8212$", () -> {});
        Then("^the next step is skipped8212$", () -> {});
    }
}
