package atm;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java8.En;

public class RegexSteps implements En {
    public RegexSteps() {
        Given("my java8 step", () -> System.out.println("step"));
    }

    @Given("my step definition")
    public void my_step_definition() {
    }
    @Given("my another step definition with param <{word}> - cukexp")

    public void my_another_step_definition(String param) {
    }

    @Given("my another step definition with param {word} - regex")
    public void my_another_step_definition_regex_based(String param) {
    }

    @Given("^step (red|black):$")
    public void my_step_with_colon(String param) {
    }

    @Given("first regex")
    @Given("second regex")
    public void my_double_definition() {
    }

    @Given("step {color}")
    public void colorParameterType() {
    }

    @ParameterType("red|blue|yellow")
    public String color(String color) {
        return "Text with color: " + color;
    }
}
