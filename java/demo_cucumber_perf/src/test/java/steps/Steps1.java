package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps1 {
    @When("^the step is implemented1$")
    public void implementedStep1() {
    }

    @Then("^the next step is executed1$")
    public void passedStep1() {
    }

    @When("^the step is not implemented yet1$")
    public void notImplementedStep1() {
    }

    @Then("^the next step is skipped1$")
    public void skippedStep1() {
    }
}
