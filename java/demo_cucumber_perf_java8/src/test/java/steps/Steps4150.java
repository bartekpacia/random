package steps;

import io.cucumber.java8.En;

public class Steps4150 implements En {

    public Steps4150() {
        When("^the step is implemented4150$", () -> {});
        When("^the step is not implemented yet4150$", () -> {});
        Then("^the next step is executed4150$", () -> {});
        Then("^the next step is skipped4150$", () -> {});
    }
}
