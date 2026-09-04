Feature: Vocabulary Quiz Generator

  @quiz
  Scenario Outline: Generate vocabulary quiz from config properties
    Given User creates a <question_count> question quiz

    Examples:
      | question_count |
      | 10             |