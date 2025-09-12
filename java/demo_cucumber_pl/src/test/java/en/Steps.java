package en;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.ParameterType;

public class Steps {

    @Given("I am hungry")
    public void iAmHungry() {
    }

    @When("I ask for advice")
    public void iAskForAdvice() {
        // no-op
    }

    @Then("I eat a {enColor} cookie")
    public void iEatCookie(String color) {
        // no-op
    }

    @ParameterType("red|blue|green")
    public String enColor(String color) {
        return "Text with color: " + color;
    }
}

