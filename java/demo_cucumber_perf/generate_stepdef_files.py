import os

# Configuration
NUM_FILES = 10_000
OUTPUT_DIR = 'src/test/java/steps/'

# Ensure the output directory exists
os.makedirs(OUTPUT_DIR, exist_ok=True)

# Java file template
JAVA_TEMPLATE = """package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsNUM {
    @When("^the step is implementedNUM$")
    public void implementedStepNUM() {
    }

    @Then("^the next step is executedNUM$")
    public void passedStepNUM() {
    }

    @When("^the step is not implemented yetNUM$")
    public void notImplementedStepNUM() {
    }

    @Then("^the next step is skippedNUM$")
    public void skippedStepNUM() {
    }
}
"""

# Generate and write the files
print(f"Generating {NUM_FILES} Java files...")
for i in range(1, NUM_FILES + 1):
    file_name = f"Steps{i}.java"
    file_path = os.path.join(OUTPUT_DIR, file_name)

    with open(file_path, 'w') as f:
        content = JAVA_TEMPLATE.replace("NUM", str(i))
        f.write(content)
        print(f"Wrote file {file_path}")

print(f"Generation complete. Files saved to: {os.path.abspath(OUTPUT_DIR)}")
