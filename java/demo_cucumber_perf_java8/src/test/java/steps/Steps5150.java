package steps;

import io.cucumber.java8.En;

public class Steps5150 implements En {

    public Steps5150() {
        When("^the step is implemented5150$", () -> {});
        When("^the step is not implemented yet5150$", () -> {});
        Then("^the next step is executed5150$", () -> {});
        Then("^the next step is skipped5150$", () -> {});
    }
}
