Feature: MyMemory Translate API Integration
  @singleTranslate
  Scenario: Translate words and save to config properties
    Given User translates "throat" to "tr" language via API
    Then User saves word "throat" and its translation to config properties

    @manyTranslate
  Scenario: Translate words and save to config properties
    Given User translates "disrespectful behavior" to "tr" language via API
    Then User saves word "disrespectful behavior" and its translation to config properties