package com.example.highlighter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Contains a comprehensive suite of JUnit 5 tests for the CucumberExpressionHighlighter.
 */
class CucumberExpressionHighlighterTest {

  private CucumberExpressionHighlighter highlighter;

  @BeforeEach
  void setUp() {
    // Initialize a new highlighter before each test to ensure isolation.
    highlighter = new CucumberExpressionHighlighter();
  }

  @Test
  @DisplayName("Should find a single parameter in the middle of a string")
  void testFindsSingleParameter() {
    String expression = "I have {int} cucumber(s) in my belly!";
    List<Range> expectedRanges = List.of(new Range(7, 11));
    List<Range> actualRanges = highlighter.findParameterRanges(expression);
    assertEquals(expectedRanges, actualRanges, "Should find one parameter from index 7 to 11.");
  }

  @Test
  @DisplayName("Should find multiple, non-adjacent parameters")
  void testFindsMultipleParameters() {
    String expression = "A {string} and an {int} and a {float}";
    List<Range> expectedRanges = List.of(new Range(2, 9), new Range(18, 22), new Range(30, 36));
    List<Range> actualRanges = highlighter.findParameterRanges(expression);
    assertEquals(expectedRanges, actualRanges, "Should correctly identify three distinct parameters.");
  }

  @Test
  @DisplayName("Should correctly handle an escaped opening brace")
  void testHandlesEscapedOpeningBrace() {
    String expression = "I have {int} \\{string}s in my belly!";
    List<Range> expectedRanges = List.of(new Range(7, 11));
    List<Range> actualRanges = highlighter.findParameterRanges(expression);
    assertEquals(expectedRanges, actualRanges, "Should ignore the escaped opening brace.");
  }

  @Test
  @DisplayName("Should correctly handle an escaped closing brace inside a parameter")
  void testHandlesEscapedClosingBrace() {
    String expression = "A parameter with an escaped brace: {type\\}}";
    List<Range> expectedRanges = List.of(new Range(33, 40));
    List<Range> actualRanges = highlighter.findParameterRanges(expression);
    assertEquals(expectedRanges, actualRanges, "The escaped closing brace should be part of the parameter.");
  }

  @Test
  @DisplayName("Should return an empty list for strings with no parameters")
  void testNoParametersFound() {
    String expression = "A simple string without any parameters.";
    List<Range> actualRanges = highlighter.findParameterRanges(expression);
    assertTrue(actualRanges.isEmpty(), "Should return an empty list when no parameters are present.");
  }

  @Test
  @DisplayName("Should return an empty list for null or empty input")
  void testHandlesNullAndEmptyInput() {
    assertTrue(highlighter.findParameterRanges(null).isEmpty(), "Null input should result in an empty list.");
    assertTrue(highlighter.findParameterRanges("").isEmpty(), "Empty string input should result in an empty list.");
  }

  @Test
  @DisplayName("Should gracefully handle an unclosed parameter by ignoring it")
  void testHandlesUnclosedParameter() {
    String expression = "An {unclosed parameter at the end";
    List<Range> actualRanges = highlighter.findParameterRanges(expression);
    assertTrue(actualRanges.isEmpty(), "Unclosed parameters should be ignored.");
  }

  @Test
  @DisplayName("Should ignore an unmatched closing brace")
  void testHandlesUnmatchedClosingBrace() {
    String expression = "This string has an extra } brace.";
    List<Range> actualRanges = highlighter.findParameterRanges(expression);
    assertTrue(actualRanges.isEmpty(), "An unmatched closing brace should not create a range.");
  }

  @Test
  @DisplayName("Should handle an escaped backslash correctly")
  void testHandlesEscapedBackslash() {
    String expression = "This is not an escape: \\\\{int}";
    List<Range> expectedRanges = List.of(new Range(26, 30));
    List<Range> actualRanges = highlighter.findParameterRanges(expression);
    assertEquals(expectedRanges, actualRanges, "An escaped backslash should not escape the following brace.");
  }

  @Test
  @DisplayName("Should handle a parameter at the very beginning of the string")
  void testParameterAtStart() {
    String expression = "{word} at the start";
    List<Range> expectedRanges = List.of(new Range(0, 5));
    List<Range> actualRanges = highlighter.findParameterRanges(expression);
    assertEquals(expectedRanges, actualRanges);
  }

  @Test
  @DisplayName("Should handle a parameter at the very end of the string")
  void testParameterAtEnd() {
    String expression = "A parameter at the {end}";
    List<Range> expectedRanges = List.of(new Range(20, 24));
    List<Range> actualRanges = highlighter.findParameterRanges(expression);
    assertEquals(expectedRanges, actualRanges);
  }
}

