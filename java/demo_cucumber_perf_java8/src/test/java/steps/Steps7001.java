package steps;

import io.cucumber.java8.En;

public class Steps7001 implements En {

    public Steps7001() {
        When("^the step is implemented7001$", () -> {});
        When("^the step is not implemented yet7001$", () -> {});
        Then("^the next step is executed7001$", () -> {});
        Then("^the next step is skipped7001$", () -> {});
    }
}
