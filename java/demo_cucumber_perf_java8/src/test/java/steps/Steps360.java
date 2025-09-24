package steps;

import io.cucumber.java8.En;

public class Steps360 implements En {

    public Steps360() {
        When("^the step is implemented360$", () -> {});
        When("^the step is not implemented yet360$", () -> {});
        Then("^the next step is executed360$", () -> {});
        Then("^the next step is skipped360$", () -> {});
    }
}
