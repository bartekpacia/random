package idea245889;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Steps {
    @Given("a snakemake project")
    public void aSnakemakeProject() {
    }

    @Given("I open a file {string} with text")
    public void openFile(String name, String text) {
    }

    @Given("{word} inspection is enabled")
    public void inspectionIsEnabled(String inspectionName) {

    }

    @When("^I expect inspection on <([^>]+)> with some message$")
    public void iExpectInspectionsOnWithMessages(String level, String signature) {
        System.out.println("level = " + level + ", signature = " + signature);
    }

    @Given("I check highlighting weak warnings")
    public void checkHighlighting() {
    }
}
