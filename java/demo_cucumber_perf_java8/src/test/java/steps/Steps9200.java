package steps;

import io.cucumber.java8.En;

public class Steps9200 implements En {

    public Steps9200() {
        When("^the step is implemented9200$", () -> {});
        When("^the step is not implemented yet9200$", () -> {});
        Then("^the next step is executed9200$", () -> {});
        Then("^the next step is skipped9200$", () -> {});
    }
}
