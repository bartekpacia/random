package steps;

import io.cucumber.java8.En;

public class Steps888 implements En {

    public Steps888() {
        When("^the step is implemented888$", () -> {});
        When("^the step is not implemented yet888$", () -> {});
        Then("^the next step is executed888$", () -> {});
        Then("^the next step is skipped888$", () -> {});
    }
}
