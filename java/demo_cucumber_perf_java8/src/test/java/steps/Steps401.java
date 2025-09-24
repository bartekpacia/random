package steps;

import io.cucumber.java8.En;

public class Steps401 implements En {

    public Steps401() {
        When("^the step is implemented401$", () -> {});
        When("^the step is not implemented yet401$", () -> {});
        Then("^the next step is executed401$", () -> {});
        Then("^the next step is skipped401$", () -> {});
    }
}
