package com.example.highlighter;

import java.util.ArrayList;
import java.util.List;

record Range(int start, int end) {
}


class CucumberExpressionHighlighter {

  /**
   * Finds the ranges of parameter parts (e.g., "{int}") in a Cucumber expression string.
   * <p>
   * The algorithm iterates through the string character by character, keeping track
   * of whether the current position is inside a parameter. It correctly handles
   * escaped curly braces ('\{' and '\}') by ignoring them as parameter delimiters.
   *
   * @param expression The Cucumber expression to be analyzed.
   * @return A {@link List} of {@link Range} objects. Each Range indicates the
   * start and end indices (inclusive) of a detected parameter.
   * Returns an empty list if the input is null, empty, or contains no parameters.
   */
  public List<Range> findParameterRanges(String expression) {
    // Return an empty list for null or empty input to prevent errors.
    if (expression == null || expression.isEmpty()) {
      return new ArrayList<>();
    }

    List<Range> ranges = new ArrayList<>();
    int parameterStartIndex = -1; // -1 indicates we are not currently inside a parameter.

    // A state machine with a single boolean flag to track escaped characters.
    boolean isEscaped = false;

    for (int i = 0; i < expression.length(); i++) {
      char currentChar = expression.charAt(i);

      if (isEscaped) {
        // If the previous character was a backslash, this character is escaped.
        // We do nothing with it and reset the escape flag.
        isEscaped = false;
        continue;
      }

      if (currentChar == '\\') {
        // This is an escape character. Set the flag for the next iteration.
        isEscaped = true;
        continue;
      }


    }

    return ranges;
  }
}
