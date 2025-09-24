package steps;

import io.cucumber.java8.En;

public class Steps2022 implements En {

    public Steps2022() {
        When("^the step is implemented2022$", () -> {});
        When("^the step is not implemented yet2022$", () -> {});
        Then("^the next step is executed2022$", () -> {});
        Then("^the next step is skipped2022$", () -> {});
    }
}
