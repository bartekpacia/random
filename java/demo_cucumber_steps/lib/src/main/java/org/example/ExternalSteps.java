package org.example;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;

public class ExternalSteps {
    public boolean someLibraryMethod() {
        return true;
    }

    @Given("I am {word}")
    public void iAm(String name) {
    }

    @Given("I have a normal {word} parameter")
    public void normal(String size) {
    }

    @Given("I have a custom {customParameter} parameter")
    public void custom(String size) {
    }

    @Given("I have this/that parameter")
    public void alternative() {

    }
    @Given("I have or not( parameter)")
    public void optional() {
    }

    @ParameterType(".*")
    public String customParameter(String arg) {
        return arg;
    }
}
