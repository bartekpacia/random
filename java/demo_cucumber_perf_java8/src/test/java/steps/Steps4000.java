package steps;

import io.cucumber.java8.En;

public class Steps4000 implements En {

    public Steps4000() {
        When("^the step is implemented4000$", () -> {});
        When("^the step is not implemented yet4000$", () -> {});
        Then("^the next step is executed4000$", () -> {});
        Then("^the next step is skipped4000$", () -> {});
    }
}
