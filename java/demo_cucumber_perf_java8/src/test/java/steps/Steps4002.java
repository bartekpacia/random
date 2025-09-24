package steps;

import io.cucumber.java8.En;

public class Steps4002 implements En {

    public Steps4002() {
        When("^the step is implemented4002$", () -> {});
        When("^the step is not implemented yet4002$", () -> {});
        Then("^the next step is executed4002$", () -> {});
        Then("^the next step is skipped4002$", () -> {});
    }
}
