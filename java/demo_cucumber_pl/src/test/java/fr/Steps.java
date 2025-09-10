package fr;

import io.cucumber.java8.Fr;

public class Steps implements Fr {
    public Steps() {
        Quand("simple", () -> {
        });

        Etantdonnéque("complex", () -> {
        });

        Etantdonné("complex2", () -> {
        });
    }
}