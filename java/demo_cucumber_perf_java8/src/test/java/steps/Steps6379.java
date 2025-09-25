package steps;

import io.cucumber.java8.En;

public class Steps6379 implements En {

    public Steps6379() {
        When("^the step is implemented6379$", () -> {});
        When("^the step is not implemented yet6379$", () -> {});
        Then("^the next step is executed6379$", () -> {});
        Then("^the next step is skipped6379$", () -> {});
    }
}
