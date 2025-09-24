package steps;

import io.cucumber.java8.En;

public class Steps17 implements En {

    public Steps17() {
        When("^the step is implemented17$", () -> {});
        When("^the step is not implemented yet17$", () -> {});
        Then("^the next step is executed17$", () -> {});
        Then("^the next step is skipped17$", () -> {});
    }
}
