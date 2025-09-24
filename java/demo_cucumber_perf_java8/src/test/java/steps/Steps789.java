package steps;

import io.cucumber.java8.En;

public class Steps789 implements En {

    public Steps789() {
        When("^the step is implemented789$", () -> {});
        When("^the step is not implemented yet789$", () -> {});
        Then("^the next step is executed789$", () -> {});
        Then("^the next step is skipped789$", () -> {});
    }
}
