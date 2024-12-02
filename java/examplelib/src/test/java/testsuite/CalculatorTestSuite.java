package testsuite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Test Suite of Calculator")
@SelectClasses({AdditionTest.class, SubtractionTest.class})
public class CalculatorTestSuite {

}
