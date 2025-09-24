package steps;

import io.cucumber.java8.En;

public class Steps1231 implements En {

    public Steps1231() {
        When("^the step is implemented1231$", () -> {});
        When("^the step is not implemented yet1231$", () -> {});
        Then("^the next step is executed1231$", () -> {});
        Then("^the next step is skipped1231$", () -> {});
    }
}
