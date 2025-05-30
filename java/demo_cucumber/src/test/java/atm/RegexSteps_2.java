package atm;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;

import java.util.List;

public class RegexSteps_2 implements En {
    @When("^I expect inspection on <([^>]+)> SHORT$")
    public void iExpectInspectionsOnWithMessages(String level) {
        System.out.println("level = " + level);
    }

    @When("^I expect inspection on <([^>]+)> with some message$")
    public void iExpectInspectionsOnWithMessages(String level, String signature) {
        System.out.println("level = " + level + ", signature = " + signature);
    }

//    @When("I expect inspection {inspectionWarningLevel} on {word} with some message")
//    public void iExpectInspectionsOnWithMessages(String level, String signature) {
//        System.out.println("level = " + level + ", signature = " + signature);
//    }

    @ParameterType("error|warning|info|TYPO|weak warning")
    public String inspectionWarningLevel(String color) {
        return "Text with color: " + color;
    }
}
