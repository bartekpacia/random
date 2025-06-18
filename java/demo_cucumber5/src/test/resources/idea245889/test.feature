Feature: IDEA-245889 reproducer

  Scenario Outline: Multiline string argument in execution section (warning on subexpression)
    Given a snakemake projectXD
    Given I open a file "foo.smk" with text
    """
    <rule_like> NAME:
        <section>: <args>, "c"
    """
    And SmkSectionMultilineStringArgsInspection inspection is enabled
    Then I expect inspection weak warning on <<warning>> with messages
    """
    Multiline string argument in '<section>' will be considered as concatenation. Maybe comma is missing.
    """
    When I check highlighting weak warnings
    Examples:
      | rule_like | section | args                                  | warning               |
      | rule      | input   | "foo" + "boo" + "doo" \n        "roo" | "doo" \n        "roo" |
      | rule      | input   | "a" + ("b" \n        "c" + "d")       | "b" \n        "c"     |
