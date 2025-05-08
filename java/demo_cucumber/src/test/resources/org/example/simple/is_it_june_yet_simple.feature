Feature: Is it June yet?
  I want to know if school is ending.

  Scenario: January isn't June
    Given current month is February
    When I ask whether it's June yet
    Then I am told "no"
