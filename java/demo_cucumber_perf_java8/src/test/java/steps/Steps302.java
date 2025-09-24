package steps;

import io.cucumber.java8.En;

public class Steps302 implements En {

    public Steps302() {
        When("^the step is implemented302$", () -> {});
        When("^the step is not implemented yet302$", () -> {});
        Then("^the next step is executed302$", () -> {});
        Then("^the next step is skipped302$", () -> {});
    }
}
