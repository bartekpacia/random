package steps;

import io.cucumber.java8.En;

public class Steps8255 implements En {

    public Steps8255() {
        When("^the step is implemented8255$", () -> {});
        When("^the step is not implemented yet8255$", () -> {});
        Then("^the next step is executed8255$", () -> {});
        Then("^the next step is skipped8255$", () -> {});
    }
}
