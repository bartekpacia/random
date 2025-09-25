package steps;

import io.cucumber.java8.En;

public class Steps10000 implements En {

    public Steps10000() {
        When("^the step is implemented10000$", () -> {});
        When("^the step is not implemented yet10000$", () -> {});
        Then("^the next step is executed10000$", () -> {});
        Then("^the next step is skipped10000$", () -> {});
    }
}
