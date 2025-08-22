package org.acme;

import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;


public class Main {
    @QuarkusMain
    public static class Nested {
        public static void main(String... args) {
            System.out.println("Running main method");
            Quarkus.run(args);
        }
    }
}