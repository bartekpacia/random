package steps;

import io.cucumber.java8.En;

public class Steps2019 implements En {

    public Steps2019() {
        When("^the step is implemented2019$", () -> {});
        When("^the step is not implemented yet2019$", () -> {});
        Then("^the next step is executed2019$", () -> {});
        Then("^the next step is skipped2019$", () -> {});
    }
}
