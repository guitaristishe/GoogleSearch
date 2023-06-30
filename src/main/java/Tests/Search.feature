Feature: Search

  Scenario: Check search field
    When user enters 'QA' in search field
    And user clicks on the 'Cautare google' button
    Then appear page with word 'QA'