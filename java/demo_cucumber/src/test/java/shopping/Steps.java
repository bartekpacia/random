package shopping;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;

public class Steps {

    @Given("my step definition")
    public void my_step_definition() {
    }

//    @Given("my another step definition with param {string}")
//    public void my_another_step_definition(String param) {
//    }

    @Given("my another step definition with param <{string}> but regex based")
    public void my_another_step_definition_regex_based(String param) {
    }

    @Given("^step (red|black):$")
    public void my_step_with_colon(String param) {
    }

//    @Given("first regex")
//    @Given("second regex")
//    public void my_double_definition() {
//    }

    @Given("step {color}")
    public void colorParameterType() {
    }

    @ParameterType("red|blue|yellow")
    public String color(String color) {
        return "Text with color: " + color;
    }
}
