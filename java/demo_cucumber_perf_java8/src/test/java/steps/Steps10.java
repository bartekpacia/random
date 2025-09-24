package steps;

import io.cucumber.java8.En;

public class Steps10 implements En {

    public Steps10() {
        When("^the step is implemented10$", () -> {});
        When("^the step is not implemented yet10$", () -> {});
        Then("^the next step is executed10$", () -> {});
        Then("^the next step is skipped10$", () -> {});
    }
}
