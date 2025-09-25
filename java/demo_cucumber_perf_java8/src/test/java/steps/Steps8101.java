package steps;

import io.cucumber.java8.En;

public class Steps8101 implements En {

    public Steps8101() {
        When("^the step is implemented8101$", () -> {});
        When("^the step is not implemented yet8101$", () -> {});
        Then("^the next step is executed8101$", () -> {});
        Then("^the next step is skipped8101$", () -> {});
    }
}
