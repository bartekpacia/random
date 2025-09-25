package steps;

import io.cucumber.java8.En;

public class Steps8090 implements En {

    public Steps8090() {
        When("^the step is implemented8090$", () -> {});
        When("^the step is not implemented yet8090$", () -> {});
        Then("^the next step is executed8090$", () -> {});
        Then("^the next step is skipped8090$", () -> {});
    }
}
