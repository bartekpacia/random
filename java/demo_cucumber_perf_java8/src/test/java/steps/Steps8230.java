package steps;

import io.cucumber.java8.En;

public class Steps8230 implements En {

    public Steps8230() {
        When("^the step is implemented8230$", () -> {});
        When("^the step is not implemented yet8230$", () -> {});
        Then("^the next step is executed8230$", () -> {});
        Then("^the next step is skipped8230$", () -> {});
    }
}
