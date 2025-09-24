package steps;

import io.cucumber.java8.En;

public class Steps3270 implements En {

    public Steps3270() {
        When("^the step is implemented3270$", () -> {});
        When("^the step is not implemented yet3270$", () -> {});
        Then("^the next step is executed3270$", () -> {});
        Then("^the next step is skipped3270$", () -> {});
    }
}
