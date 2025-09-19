package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps123 {
    @When("^the step is implemented123$")
    public void implementedStep123() {
    }

    @Then("^the next step is executed123$")
    public void passedStep123() {
    }

    @When("^the step is not implemented yet123$")
    public void notImplementedStep123() {
    }

    @Then("^the next step is skipped123$")
    public void skippedStep123() {
    }
}
