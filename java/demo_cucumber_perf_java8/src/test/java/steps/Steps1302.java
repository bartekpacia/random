package steps;

import io.cucumber.java8.En;

public class Steps1302 implements En {

    public Steps1302() {
        When("^the step is implemented1302$", () -> {});
        When("^the step is not implemented yet1302$", () -> {});
        Then("^the next step is executed1302$", () -> {});
        Then("^the next step is skipped1302$", () -> {});
    }
}
