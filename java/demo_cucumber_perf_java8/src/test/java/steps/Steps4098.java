package steps;

import io.cucumber.java8.En;

public class Steps4098 implements En {

    public Steps4098() {
        When("^the step is implemented4098$", () -> {});
        When("^the step is not implemented yet4098$", () -> {});
        Then("^the next step is executed4098$", () -> {});
        Then("^the next step is skipped4098$", () -> {});
    }
}
