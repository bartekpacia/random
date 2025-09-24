package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps22098 {
    @When("^the step is implemented22098$")
    public void implementedStep22098() {
    }

    @Then("^the next step is executed22098$")
    public void passedStep22098() {
    }

    @When("^the step is not implemented yet22098$")
    public void notImplementedStep22098() {
    }

    @Then("^the next step is skipped22098$")
    public void skippedStep22098() {
    }
}
