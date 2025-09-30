package org.deepexample;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;

public class DeepSteps {

    @Given("I have a deep custom {deepCustomParameter} parameter")
    public void custom(String size) {
    }

    @ParameterType(".*")
    public String deepCustomParameter(String arg) {
        return arg;
    }
}
