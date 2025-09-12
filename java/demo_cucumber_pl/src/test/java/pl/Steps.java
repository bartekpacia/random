package pl;

import io.cucumber.java.ParameterType;
import io.cucumber.java8.Pl;

@SuppressWarnings("NonAsciiCharacters")
public class Steps implements Pl {

    public Steps() {
        Zakładając("jestem głodny", () -> {
            Thread.sleep(1000);
        });

        Kiedy("proszę o radę", () -> {
        });

        Wtedy("jem {plColor} ciastko", (String color) -> {
        });
    }

    @ParameterType("czerwone|niebieskie|zielone")
    public String plColor(String color) {
        return "Text with color: " + color;
    }
}
