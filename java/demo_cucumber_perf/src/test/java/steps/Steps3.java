package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps3 {
    @When("^the step is implemented3$")
    public void implementedStep3() {
    }

    @Then("^the next step is executed3$")
    public void passedStep3() {
    }

    @When("^the step is not implemented yet3$")
    public void notImplementedStep3() {
    }

    @Then("^the next step is skipped3$")
    public void skippedStep3() {
    }
}
