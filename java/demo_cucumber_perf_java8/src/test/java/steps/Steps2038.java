package steps;

import io.cucumber.java8.En;

public class Steps2038 implements En {

    public Steps2038() {
        When("^the step is implemented2038$", () -> {});
        When("^the step is not implemented yet2038$", () -> {});
        Then("^the next step is executed2038$", () -> {});
        Then("^the next step is skipped2038$", () -> {});
    }
}
