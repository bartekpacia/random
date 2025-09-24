import os

# Configuration
NUM_FILES = 5000
OUTPUT_DIR = 'src/test/java/steps/'

# Ensure the output directory exists
os.makedirs(OUTPUT_DIR, exist_ok=True)

# Java file template
JAVA_TEMPLATE = """package steps;

import io.cucumber.java8.En;

public class StepsNUM implements En {

    public StepsNUM() {
        When("^the step is implementedNUM$", () -> {});
        When("^the step is not implemented yetNUM$", () -> {});
        Then("^the next step is executedNUM$", () -> {});
        Then("^the next step is skippedNUM$", () -> {});
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
