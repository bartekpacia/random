package renameParameter;

import io.cucumber.java.en.Given;

public class Steps {
    @Given("{word} like {word}")
    public void foo(String first, String second) {
    }

    @Given("{word} is noice")
    public void bar(String first) {
    }
}
