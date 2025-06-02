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

    @When("^I expect inspection (error|warning|info|TYPO|weak warning) on <([^>]+)> with messages$")
    public void iExpectInspectionsOnWithMessages(String level, String signature, String messages) {
        System.out.println("level = " + level + ", signature = " + signature + ", messages = " + messages);
    }

    @Given("I check highlighting weak warnings")
    public void checkHighlighting() {
    }

    @Given("a snakemake projectXD")
    public void aSnakemakeProjectXD() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
