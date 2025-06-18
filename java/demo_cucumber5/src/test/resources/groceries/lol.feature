Feature: Shopping

  Scenario: Give correct change
    Given The following groceries:
      | name  | price |
      | milk  | 9     |
      | bread | 7     |
      | soap  | 5     |
    When I pay 25
    Then My change should be 4
