package org.example;

public class IsItFriday {
    public static String isItFriday(String today) {
        return "friday".equalsIgnoreCase(today) ? "Thank God It's Friday" : "Nope";
    }

    public static String isWeekend(String today) {
        return "saturday".equalsIgnoreCase(today) || "sunday".equalsIgnoreCase(today) ? "Yes" : "Nope";
    }
}
