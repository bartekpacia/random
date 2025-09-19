package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps1101 {
    @When("^the step is implemented1101$")
    public void implementedStep1101() {
    }

    @Then("^the next step is executed1101$")
    public void passedStep1101() {
    }

    @When("^the step is not implemented yet1101$")
    public void notImplementedStep1101() {
    }

    @Then("^the next step is skipped1101$")
    public void skippedStep1101() {
    }
}
