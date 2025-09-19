package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps101 {
    @When("^the step is implemented101$")
    public void implementedStep101() {
    }

    @Then("^the next step is executed101$")
    public void passedStep101() {
    }

    @When("^the step is not implemented yet101$")
    public void notImplementedStep101() {
    }

    @Then("^the next step is skipped101$")
    public void skippedStep101() {
    }
}
