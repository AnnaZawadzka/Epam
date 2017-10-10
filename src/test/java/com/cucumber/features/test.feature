Feature: Payment validation declined card

  Scenario: Payment validation declined card
    Given I have a booking with any PAX
    And I proceed to payment page
    When I pay for a flight using not existing card
    Then my payment is declined with validation message
