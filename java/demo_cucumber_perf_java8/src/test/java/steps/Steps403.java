package steps;

import io.cucumber.java8.En;

public class Steps403 implements En {

    public Steps403() {
        When("^the step is implemented403$", () -> {});
        When("^the step is not implemented yet403$", () -> {});
        Then("^the next step is executed403$", () -> {});
        Then("^the next step is skipped403$", () -> {});
    }
}
