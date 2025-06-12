package groceries;

import io.cucumber.java8.En;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps implements En {
    public Steps() {
        Given("some java8 step", () -> {
        });
    }

    @Given("^The following groceries:$")
    public void the_following_groceries(DataTable table) {
    }

    @Then("My change should be {int}")
    public void my_change_should_be(int change) {
    }

    @When("I pay {int}")
    public void I_pay(int amount) {

    }

    @Then("^ am out of milk$") // Test for IDEA-371083
    public void out_of_milk() {
    }
}

