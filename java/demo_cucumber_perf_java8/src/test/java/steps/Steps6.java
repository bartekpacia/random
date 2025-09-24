package steps;

import io.cucumber.java8.En;

public class Steps6 implements En {

    public Steps6() {
        When("^the step is implemented6$", () -> {});
        When("^the step is not implemented yet6$", () -> {});
        Then("^the next step is executed6$", () -> {});
        Then("^the next step is skipped6$", () -> {});
    }
}
