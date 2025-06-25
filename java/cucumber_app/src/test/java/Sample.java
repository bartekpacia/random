import org.example.ExternalSteps;

// Just a class to make sure that the library with Cucumber step definitions is properly attached.
public class Sample {
    public void foo() {
        ExternalSteps steps = new ExternalSteps();
        steps.someLibraryMethod();
    }
}
