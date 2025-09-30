import os

# Configuration
NUM_FILES = 5_000
OUTPUT_DIR = 'src/resources/'

# Ensure the output directory exists
os.makedirs(OUTPUT_DIR, exist_ok=True)

FILE_TEMPLATE = """
Feature: Already implemented.

  Scenario:
    When the step throws an exceptionNUM
    Then the next step is executedNUM

  Scenario:
    When the step is implementedNUM
    Then the next step is executedNUM
"""

# Generate and write the files
print(f"Generating {NUM_FILES} Gherkin files...")
for i in range(1, NUM_FILES + 1):
    file_name = f"resourcesfilename{i}.feature"
    file_path = os.path.join(OUTPUT_DIR, file_name)

    with open(file_path, 'w') as f:
        content = FILE_TEMPLATE.replace("NUM", str(i))
        f.write(content)
        print(f"Wrote file {file_path}")

print(f"Generation complete. Files saved to: {os.path.abspath(OUTPUT_DIR)}")
