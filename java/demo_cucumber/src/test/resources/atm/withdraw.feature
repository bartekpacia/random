Feature: Withdraw money
  As a customer
  In order to avoid going to the bank
  I want to withdraw money from an ATM

  Scenario: Withdraw less money than the account has
    Given I have 200 EUR on my account
    When I withdraw 100 EUR
    Then I get 100 EUR from the ATM
    And My account has 100 EUR left
    And I am happy

  Scenario: Withdraw more money than the account has
    Given I have 50 EUR on my account
    When I withdraw 100 EUR
    Then I get 0 EUR from the ATM
    And My account has 50 EUR left
    And error message about the lack of money is displayed
    And I am angry

  Scenario: Withdraw more money than the account has (copy)
    Given I have 60 EUR on my account
    When I withdraw 100 EUR
    Then I get 0 EUR from the ATM
    And My account has 60 EUR left
    And error message about the lack of money is displayed
    And I am angry

  @allure.id:2048
  @moved_to_pcwf
  @allure.label.epic:MP-11487
  @allure.label.testType:positive
  @allure.label.service:pc
  Scenario: Withdraw negative amount from the account
    Given I have 70 EUR on my account
    When I withdraw -1 EUR
    Then I get 0 EUR from the ATM
    And My account has 70 EUR left
    And error message about incorrect amount is displayed
    And I am angry

  Scenario: Withdraw negative amount from the account
    Given I have 70 EUR on my account
    When I withdraw -1 EUR
    Then I get 0 EUR from the ATM
    And My account has 70 EUR left
    And error message about incorrect amount is displayed
    And I am angry

  Scenario: Withdraw negative amount from the account
    Given I have 70 EUR on my account
    When I withdraw -1 EUR
    Then I get 0 EUR from the ATM
    And My account has 70 EUR left
    And error message about incorrect amount is displayed
    And I am angry