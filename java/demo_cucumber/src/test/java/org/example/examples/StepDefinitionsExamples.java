package org.example.examples;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.IsItFriday;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitionsExamples {
    private String today;
    private String actualAnswer;

    @Given("today is {string}")
    public void today_is_day(String expectedDay) {
        today = expectedDay;
    }

    @When("I ask whether it's Friday yet EXAMPLES")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string} EXAMPLES")
    public void i_should_be_told(String expectedAnswer) {
        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}