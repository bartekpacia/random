package steps;

import io.cucumber.java8.En;

public class Steps1890 implements En {

    public Steps1890() {
        When("^the step is implemented1890$", () -> {});
        When("^the step is not implemented yet1890$", () -> {});
        Then("^the next step is executed1890$", () -> {});
        Then("^the next step is skipped1890$", () -> {});
    }
}
