package steps;

import io.cucumber.java8.En;

public class Steps404 implements En {

    public Steps404() {
        When("^the step is implemented404$", () -> {});
        When("^the step is not implemented yet404$", () -> {});
        Then("^the next step is executed404$", () -> {});
        Then("^the next step is skipped404$", () -> {});
    }
}
