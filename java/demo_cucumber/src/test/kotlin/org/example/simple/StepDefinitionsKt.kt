package org.example.simple

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions
import org.example.IsItFriday

class StepDefinitionsKt {
    private var currentMonth: String? = null
    private var wantedMonth: String? = null

    @Given("current month is January")
    fun current_month_is_January() {
        currentMonth = "January"
    }

    @Given("current month is February")
    fun current_month_is_February() {
        currentMonth = "February"
    }

    @Given("current month is March")
    fun current_month_is_March() {
        currentMonth = "March"
    }

    @When("I ask whether it's June yet")
    fun i_ask_whether_it_s_June_yet() {
        wantedMonth = IsItFriday.isItFriday(currentMonth)
    }

    @Then("I should be told {string}")
    fun i_should_be_told(expectedAnswer: String?) {
        Assertions.assertThat(wantedMonth).isEqualTo(expectedAnswer)
    }
}