package com.example;

public class Foo {
    private final String data;

    Foo(String data) {
        this.data = data;
    }

    public boolean isValid() {
        return data.length() % 2 == 0;
    }

    // some other methods that make use of the encapsulated information, for example returning it in different formats
}
