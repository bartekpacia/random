package steps;

import io.cucumber.java8.En;

public class Steps2020 implements En {

    public Steps2020() {
        When("^the step is implemented2020$", () -> {});
        When("^the step is not implemented yet2020$", () -> {});
        Then("^the next step is executed2020$", () -> {});
        Then("^the next step is skipped2020$", () -> {});
    }
}
