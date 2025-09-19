package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps2048 {
    @When("^the step is implemented2048$")
    public void implementedStep2048() {
    }

    @Then("^the next step is executed2048$")
    public void passedStep2048() {
    }

    @When("^the step is not implemented yet2048$")
    public void notImplementedStep2048() {
    }

    @Then("^the next step is skipped2048$")
    public void skippedStep2048() {
    }
}
