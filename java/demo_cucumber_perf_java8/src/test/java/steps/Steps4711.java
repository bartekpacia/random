package steps;

import io.cucumber.java8.En;

public class Steps4711 implements En {

    public Steps4711() {
        When("^the step is implemented4711$", () -> {});
        When("^the step is not implemented yet4711$", () -> {});
        Then("^the next step is executed4711$", () -> {});
        Then("^the next step is skipped4711$", () -> {});
    }
}
