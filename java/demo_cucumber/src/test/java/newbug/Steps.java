package newbug;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Steps {
    @Given("I am finding a bug")
    @When("I am finding a {word}")
    public void foo() {
        // TODO: step definitions can't be duplicated (exact same name)
        //  We get: io.cucumber.core.runner.DuplicateStepDefinitionException: Duplicate step definitions in

        // TODO: steps shouldn't match more than single definition
        //  We get: io.cucumber.core.runner.AmbiguousStepDefinitionsException: "I am finding a bug" matches more than one step definition:
    }
}
