package org.example;

public class IsItFriday {
    public static String isItFriday(String today) {
        return "friday".equalsIgnoreCase(today) ? "Thank God It's Friday" : "Nope";
    }
}
