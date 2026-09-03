Feature: MyMemory Translate API Integration
  @singleTranslate
  Scenario: Translate words and save to config properties
    Given User translates "mystry" to "tr" language via API
    Then User saves word "mystry" and its translation to config properties