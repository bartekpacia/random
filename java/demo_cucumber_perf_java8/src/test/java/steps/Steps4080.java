package steps;

import io.cucumber.java8.En;

public class Steps4080 implements En {

    public Steps4080() {
        When("^the step is implemented4080$", () -> {});
        When("^the step is not implemented yet4080$", () -> {});
        Then("^the next step is executed4080$", () -> {});
        Then("^the next step is skipped4080$", () -> {});
    }
}
