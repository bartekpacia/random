package steps;

import io.cucumber.java8.En;

public class Steps7500 implements En {

    public Steps7500() {
        When("^the step is implemented7500$", () -> {});
        When("^the step is not implemented yet7500$", () -> {});
        Then("^the next step is executed7500$", () -> {});
        Then("^the next step is skipped7500$", () -> {});
    }
}
