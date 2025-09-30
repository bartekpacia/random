# demo_cucumber_perf

Project for testing performance of the IntelliJ Cucumber plugin.

Regenerate Gherkin files:

```
python generate_gherkin_files.py
```

Regenerate Java files:

```python
python generate_stepdef_files.py
```


### Gherkin

5 000 Gherkin feature files, each with 2 scenarios, each scenario with 2 steps
20 000 total step references.

### Java

10 000 Java step definition files, each file defines 4 steps in Java annotation style.
40 000 total step definitions.
