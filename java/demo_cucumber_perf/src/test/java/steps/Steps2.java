package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps2 {
    @When("^the step is implemented2$")
    public void implementedStep2() {
    }

    @Then("^the next step is executed2$")
    public void passedStep2() {
    }

    @When("^the step is not implemented yet2$")
    public void notImplementedStep2() {
    }

    @Then("^the next step is skipped2$")
    public void skippedStep2() {
    }
}
