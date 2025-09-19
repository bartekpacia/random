package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps4 {
    @When("^the step is implemented4$")
    public void implementedStep4() {
    }

    @Then("^the next step is executed4$")
    public void passedStep4() {
    }

    @When("^the step is not implemented yet4$")
    public void notImplementedStep4() {
    }

    @Then("^the next step is skipped4$")
    public void skippedStep4() {
    }
}
