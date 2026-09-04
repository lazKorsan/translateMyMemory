Feature: MyMemory Translate API Integration
  @singleTranslate
  Scenario: Translate words and save to config properties
    Given User translates "pleasure" to "tr" language via API
    Then User saves word "plasure" and its translation to config properties

    @manyTranslate
  Scenario: Translate words and save to config properties
    Given User translates "crack the egg" to "tr" language via API
    Then User saves word "crack the egg" and its translation to config properties