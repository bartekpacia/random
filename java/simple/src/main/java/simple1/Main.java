package simple1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// demo of regex DDOS
public class Main {
    public static void main(String[] args) {
        for (int i = 10; i < 1_000_000_000; i = i * 10) {
            System.out.println("-> TEST for len(str) = " + i);

            String text = "a".repeat(i);
            Pattern pattern = Pattern.compile("(a*)*b");

            long startTime = System.nanoTime();
            Matcher matcher = pattern.matcher(text);

            matcher.find();

            long endTime = System.nanoTime();
            System.out.println("Pattern matcher execution time: " + ((endTime - startTime) / 1_000_000) + " ms");
        }
    }
}