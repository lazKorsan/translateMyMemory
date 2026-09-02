Feature: Google Translate API Integration

  @translate
  Scenario Outline: Translate words and save to config properties
    Given User translates "<word>" to "tr" language via API
    Then User saves word "<word>" and its translation to config properties

    Examples:
      | word       |
      | Hello      |
      | Apple      |
      | Computer   |
      | Software Testing |

@allow
  Scenario: Translate words and save to config properties
    Given User translates "allow" to "tr" language via API
    Then User saves word "allow" and its translation to config properties