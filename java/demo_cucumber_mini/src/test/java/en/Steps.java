package en;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.ParameterType;

public class Steps {

    @Given("I am hungry")
    public void iAmHungrys() {
        // no-op
    }

    @When("I ask for advice")
    public void iAskForAdvice() {
        // no-op
    }

    @Then("I eat a red cookie")
    public void iEatCookie(String color) {
        // no-op
    }
}

