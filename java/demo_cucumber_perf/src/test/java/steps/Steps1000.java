package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps1000 {
    @When("^the step is implemented1000$")
    public void implementedStep1000() {
    }

    @Then("^the next step is executed1000$")
    public void passedStep1000() {
    }

    @When("^the step is not implemented yet1000$")
    public void notImplementedStep1000() {
    }

    @Then("^the next step is skipped1000$")
    public void skippedStep1000() {
    }
}
