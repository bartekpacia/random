package steps;

import io.cucumber.java8.En;

public class Steps2023 implements En {

    public Steps2023() {
        When("^the step is implemented2023$", () -> {});
        When("^the step is not implemented yet2023$", () -> {});
        Then("^the next step is executed2023$", () -> {});
        Then("^the next step is skipped2023$", () -> {});
    }
}
