Feature: Shopping

  Scenario Outline: Multiline string argument in execution section (warning on subexpression)
    Given a snakemake project
    Given I open a file "foo.smk" with text
    """
    <rule_like> NAME:
        <section>: <args>, "c"
    """
    And "SmkSectionMultilineStringArgsInspection" inspection is enabled
    Then I expect inspection warning on <xd> with some message
    Then I expect inspection weak warning on xd with some message
    Then I expect inspection weak warning on <<warning>> with some message
    When I check highlighting weak warnings
    Examples:
      | rule_like | section | args                                  | warning               |
      | rule      | input   | "foo" + "boo" + "doo" \n        "roo" | "doo" \n        "roo" |
      | rule      | input   | "a" + ("b" \n        "c" + "d")       | "b" \n        "c"     |