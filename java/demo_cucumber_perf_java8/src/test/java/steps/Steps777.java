package steps;

import io.cucumber.java8.En;

public class Steps777 implements En {

    public Steps777() {
        When("^the step is implemented777$", () -> {});
        When("^the step is not implemented yet777$", () -> {});
        Then("^the next step is executed777$", () -> {});
        Then("^the next step is skipped777$", () -> {});
    }
}
