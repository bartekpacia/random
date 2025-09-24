package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps8601 {
    @When("^the step is implemented8601$")
    public void implementedStep8601() {
    }

    @Then("^the next step is executed8601$")
    public void passedStep8601() {
    }

    @When("^the step is not implemented yet8601$")
    public void notImplementedStep8601() {
    }

    @Then("^the next step is skipped8601$")
    public void skippedStep8601() {
    }
}
