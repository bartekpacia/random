Feature: Is it June yet?
  I want to know if school is ending.

  Scenario: January isn't June
    Given today is Jan
    When I ask whether it's Friday yet
    Then I should be told "Nope"