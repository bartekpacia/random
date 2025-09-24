package steps;

import io.cucumber.java8.En;

public class Steps4 implements En {

    public Steps4() {
        When("^the step is implemented4$", () -> {});
        When("^the step is not implemented yet4$", () -> {});
        Then("^the next step is executed4$", () -> {});
        Then("^the next step is skipped4$", () -> {});
    }
}
