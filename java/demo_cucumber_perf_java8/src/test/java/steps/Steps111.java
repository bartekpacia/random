package steps;

import io.cucumber.java8.En;

public class Steps111 implements En {

    public Steps111() {
        When("^the step is implemented111$", () -> {});
        When("^the step is not implemented yet111$", () -> {});
        Then("^the next step is executed111$", () -> {});
        Then("^the next step is skipped111$", () -> {});
    }
}
