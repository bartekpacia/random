package steps;

import io.cucumber.java8.En;

public class Steps601 implements En {

    public Steps601() {
        When("^the step is implemented601$", () -> {});
        When("^the step is not implemented yet601$", () -> {});
        Then("^the next step is executed601$", () -> {});
        Then("^the next step is skipped601$", () -> {});
    }
}
