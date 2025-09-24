package steps;

import io.cucumber.java8.En;

public class Steps5 implements En {

    public Steps5() {
        When("^the step is implemented5$", () -> {});
        When("^the step is not implemented yet5$", () -> {});
        Then("^the next step is executed5$", () -> {});
        Then("^the next step is skipped5$", () -> {});
    }
}
