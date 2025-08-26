Feature: Eating

  Scenario: First scenario
    Given There are 3 cucumbers on the table
    When I eat 1 cucumber
    Then I have 1 cucumber in my belly
    And There are 2 cucumbers on the table
    And I have red cucumber
