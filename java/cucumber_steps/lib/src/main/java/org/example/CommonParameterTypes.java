package org.example;

import io.cucumber.cucumberexpressions.ParameterType;

public class CommonParameterTypes {
    public static ParameterType<String> getDependencyParamType() {
        return new ParameterType<>("dependencyParamType", "(match|me)", String.class, (String s) -> s);
    }

}
