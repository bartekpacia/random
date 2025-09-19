package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps1001 {
    @When("^the step is implemented1001$")
    public void implementedStep1001() {
    }

    @Then("^the next step is executed1001$")
    public void passedStep1001() {
    }

    @When("^the step is not implemented yet1001$")
    public void notImplementedStep1001() {
    }

    @Then("^the next step is skipped1001$")
    public void skippedStep1001() {
    }
}
