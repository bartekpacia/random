package atm;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WithdrawSteps {

    private static Integer returnedAmount;

    @Given("I have {int} EUR on my account")
    public void i_have_EUR_on_my_account(int EUR) throws Throwable {
    }

    @When("^I withdraw (-?\\d+) EUR$")
    public void withdraw_EUR(int EUR) {
    }

    @Then("I get {int} EUR from the ATM")
    public void i_get_EUR_from_the_ATM(int EUR) {
    }

    @Then("error message about the lack of money is displayed")
    public void error_message_about_the_lack_of_money_is_displayed() {
    }

    @Then("My account has {int} EUR left")
    public void my_account_has_EUR_left(int EUR) {
    }

    @Then("error message about incorrect amount is displayed")
    public void error_message_about_incorrect_amount_is_displayed() {
    }

    @Then("I am happy")
    public void i_am_happy() {
    }

    @Then("^I am angry$")
    public void i_am_angry() {
    }

    @Given("I don't have any euro(s) on my account")
    public void I_dont_have_any_euros(int euros) {
    }

    @Then("I have single/many emotion(s)")
    public void I_have_emotions() {
    }
}
