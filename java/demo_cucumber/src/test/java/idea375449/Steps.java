package idea375449;

import io.cucumber.java.en.Given;

public class Steps {
    @Given("I expect inspection warning on {word} with messages 1")
    public void iExpectInspection1(String type) {
    }

    @Given("I expect inspection warning on <{word}> with messages 2")
    public void iExpectInspection2(String type) {
    }

    @Given("I expect inspection warning on < <{word}>> with messages 3")
    public void iExpectInspection3(String type) {
    }

    @Given("I expect inspection warning on <<{word}>> with messages 4")
    public void iExpectInspection4(String type) {
    }

    @Given("my another step definition with param {string}")
    public void my_another_step_definition(String param) {
    }
}
