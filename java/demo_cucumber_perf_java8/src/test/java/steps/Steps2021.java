package steps;

import io.cucumber.java8.En;

public class Steps2021 implements En {

    public Steps2021() {
        When("^the step is implemented2021$", () -> {});
        When("^the step is not implemented yet2021$", () -> {});
        Then("^the next step is executed2021$", () -> {});
        Then("^the next step is skipped2021$", () -> {});
    }
}
