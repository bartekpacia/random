package steps;

import io.cucumber.java8.En;

public class Steps200 implements En {

    public Steps200() {
        When("^the step is implemented200$", () -> {});
        When("^the step is not implemented yet200$", () -> {});
        Then("^the next step is executed200$", () -> {});
        Then("^the next step is skipped200$", () -> {});
    }
}
