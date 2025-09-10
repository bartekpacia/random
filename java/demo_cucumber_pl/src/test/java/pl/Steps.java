package pl;

import io.cucumber.java8.Pl;

@SuppressWarnings("NonAsciiCharacters")
public class Steps implements Pl {

    public Steps() {
        Zakładając("jestem głodny", () -> {
            Thread.sleep(1000);
        });

        Kiedy("proszę o radę", () -> {
        });

        Wtedy("jem ciastko", () -> {
        });
    }
}
