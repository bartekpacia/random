package steps;

import io.cucumber.java8.En;

public class Steps1337 implements En {

    public Steps1337() {
        When("^the step is implemented1337$", () -> {});
        When("^the step is not implemented yet1337$", () -> {});
        Then("^the next step is executed1337$", () -> {});
        Then("^the next step is skipped1337$", () -> {});
    }
}
