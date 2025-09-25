package steps;

import io.cucumber.java8.En;

public class Steps5432 implements En {

    public Steps5432() {
        When("^the step is implemented5432$", () -> {});
        When("^the step is not implemented yet5432$", () -> {});
        Then("^the next step is executed5432$", () -> {});
        Then("^the next step is skipped5432$", () -> {});
    }
}
