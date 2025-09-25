package steps;

import io.cucumber.java8.En;

public class Steps5500 implements En {

    public Steps5500() {
        When("^the step is implemented5500$", () -> {});
        When("^the step is not implemented yet5500$", () -> {});
        Then("^the next step is executed5500$", () -> {});
        Then("^the next step is skipped5500$", () -> {});
    }
}
