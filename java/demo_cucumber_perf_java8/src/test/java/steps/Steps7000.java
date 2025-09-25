package steps;

import io.cucumber.java8.En;

public class Steps7000 implements En {

    public Steps7000() {
        When("^the step is implemented7000$", () -> {});
        When("^the step is not implemented yet7000$", () -> {});
        Then("^the next step is executed7000$", () -> {});
        Then("^the next step is skipped7000$", () -> {});
    }
}
