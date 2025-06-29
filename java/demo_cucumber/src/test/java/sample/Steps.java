package sample;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
    @Then("I have {int} cucumber(s) in my belly")
    public void I_have_cucumbers_in_my_belly(int cukes) {

    }

    @When("I eat {int} cucumber(s)")
    public void iEatCucumber(int cukes) {
    }
}
