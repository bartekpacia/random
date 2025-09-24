package steps;

import io.cucumber.java8.En;

public class Steps1080 implements En {

    public Steps1080() {
        When("^the step is implemented1080$", () -> {});
        When("^the step is not implemented yet1080$", () -> {});
        Then("^the next step is executed1080$", () -> {});
        Then("^the next step is skipped1080$", () -> {});
    }
}
