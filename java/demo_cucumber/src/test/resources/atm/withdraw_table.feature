Feature: Withdraw money (table-based)

  Some description

  @allure.id:2048
  @moved_to_pcwf
  @allure.label.epic:MP-11487
  @allure.label.testType:positive
  @allure.label.service:pc
  Scenario Outline: Withdrawing money subtracts correct amount (start: <start>)
    Given I have <<start>> EUR on my account
    When I withdraw <subtract_amount> EUR
    Then My account has <end> EUR left

    Examples:
      | start | subtract_amount | end |
      | 100   | 25              | 75  |
      | 150   | 50              | 100 |



