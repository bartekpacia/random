package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExternalSteps {
    public boolean someLibraryMethod() {
        return true;
    }

    @Given("There are {int} cucumber(s) on the table")
    public void there_are_cucumbers_on_the_table(int cukes) {
    }

    @When("I eat {int} cucumber(s)")
    public void i_eat_cucumber(int cukes) {
    }

    @Then("I have {int} cucumber(s) in my belly")
    public void i_have_cucumbers_in_my_belly(int cukes) {
    }
}
