package atm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class WithdrawSteps {

    private static Account account;
    private static ATM atm = new ATM();
    private static Integer returnedAmount;

    @Given("I have {int} EUR on my account")
    public void i_have_EUR_on_my_account(int EUR) throws Throwable {
        account = new Account(EUR);
    }

    @When("I withdraw {int} EUR")
    public void withdraw_EUR(int EUR) throws Throwable {
        returnedAmount = atm.withdraw(account, EUR);
    }

    @Then("I get {int} EUR from the ATM")
    public void i_get_EUR_from_the_ATM(int EUR) throws Throwable {
        assertThat(returnedAmount, is(EUR));
    }

    @Then("error message about the lack of money is displayed")
    public void error_message_about_the_lack_of_money_is_displayed() throws Throwable {
        assertThat(atm.getScreen(), is("Your account dont have enough money!"));
    }

    @Then("My account has {int} EUR left")
    public void my_account_has_EUR_left(int EUR) throws Throwable {
        assertThat(account.getBalance(), is(EUR));
    }

    @Then("error message about incorrect amount is displayed")
    public void error_message_about_incorrect_amount_is_displayed() throws Throwable {
        assertThat(atm.getScreen(), is("Cannot withdraw negative amount!"));
    }

    @Then("I am happy")
    public void i_am_happy() throws Throwable {
    }

    @Then("I am angry")
    public void i_am_angry() throws Throwable {
    }
}
