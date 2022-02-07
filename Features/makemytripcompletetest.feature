Feature: verifying functionalities in makemytrip portal

  Scenario: verifying functionalities in makemytrip portal
    Given Given user is already on home page
    When user select source and destination
    When user select departure and return date
    When user select passengers like adults and childrens combination
    When user select low priced airlines and click book now button
    Then user navigate to paymentgate way page






