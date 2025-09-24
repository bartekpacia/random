package steps;

import io.cucumber.java8.En;

public class Steps4500 implements En {

    public Steps4500() {
        When("^the step is implemented4500$", () -> {});
        When("^the step is not implemented yet4500$", () -> {});
        Then("^the next step is executed4500$", () -> {});
        Then("^the next step is skipped4500$", () -> {});
    }
}
