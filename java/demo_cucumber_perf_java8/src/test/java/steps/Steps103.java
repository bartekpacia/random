package steps;

import io.cucumber.java8.En;

public class Steps103 implements En {

    public Steps103() {
        When("^the step is implemented103$", () -> {});
        When("^the step is not implemented yet103$", () -> {});
        Then("^the next step is executed103$", () -> {});
        Then("^the next step is skipped103$", () -> {});
    }
}
