package steps;

import io.cucumber.java8.En;

public class Steps101 implements En {

    public Steps101() {
        When("^the step is implemented101$", () -> {});
        When("^the step is not implemented yet101$", () -> {});
        Then("^the next step is executed101$", () -> {});
        Then("^the next step is skipped101$", () -> {});
    }
}
