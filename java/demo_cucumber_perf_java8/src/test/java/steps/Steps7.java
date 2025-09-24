package steps;

import io.cucumber.java8.En;

public class Steps7 implements En {

    public Steps7() {
        When("^the step is implemented7$", () -> {});
        When("^the step is not implemented yet7$", () -> {});
        Then("^the next step is executed7$", () -> {});
        Then("^the next step is skipped7$", () -> {});
    }
}
