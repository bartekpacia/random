Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario Outline: Today is or is not Friday
    Given today is "<day>"
    When I ask whether it's Friday yet EXAMPLES
    Then I should be told "<answer>" EXAMPLES

    Examples:
      | day            | answer                |
      | Friday         | Thank God It's Friday |
      | Sunday         | Nope                  |
      | anything else! | Nope                  |