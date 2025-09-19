package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsNUM {
    @When("^the step is implementedNUM$")
    public void implementedStep() {
    }

    @Then("^the next step is executedNUM$")
    public void passedStep() {
    }

    @When("^the step is not implemented yetNUM$")
    public void notImplementedStep() {
    }

    @Then("^the next step is skippedNUM$")
    public void skippedStep() {
    }
}
