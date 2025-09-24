package steps;

import io.cucumber.java8.En;

public class Steps11 implements En {

    public Steps11() {
        When("^the step is implemented11$", () -> {});
        When("^the step is not implemented yet11$", () -> {});
        Then("^the next step is executed11$", () -> {});
        Then("^the next step is skipped11$", () -> {});
    }
}
