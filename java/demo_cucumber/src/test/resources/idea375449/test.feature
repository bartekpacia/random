Feature: IDEA-245889 reproducer

  Scenario Outline: Some title 1
    Given I expect inspection warning on <type> with messages 1
    Examples:
      | type   |
      | class  |
      | method |
      | field  |

  Scenario Outline: Some title 2
    Given I expect inspection warning on <<type>> with messages 2
    Examples:
      | type   |
      | class  |
      | method |
      | field  |

  Scenario Outline: Some title 3
    Given I expect inspection warning on <<<type>>> with messages 3
    Examples:
      | type   |
      | class  |
      | method |
      | field  |

  Scenario Outline: Double caret test
    Given my another step definition with param "<<param>>"
    Examples:
      | param |
      | hello |
      | there |