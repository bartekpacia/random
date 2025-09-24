package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps8080 {
    @When("^the step is implemented8080$")
    public void implementedStep8080() {
    }

    @Then("^the next step is executed8080$")
    public void passedStep8080() {
    }

    @When("^the step is not implemented yet8080$")
    public void notImplementedStep8080() {
    }

    @Then("^the next step is skipped8080$")
    public void skippedStep8080() {
    }
}
