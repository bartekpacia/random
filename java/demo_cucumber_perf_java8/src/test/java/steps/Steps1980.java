package steps;

import io.cucumber.java8.En;

public class Steps1980 implements En {

    public Steps1980() {
        When("^the step is implemented1980$", () -> {});
        When("^the step is not implemented yet1980$", () -> {});
        Then("^the next step is executed1980$", () -> {});
        Then("^the next step is skipped1980$", () -> {});
    }
}
