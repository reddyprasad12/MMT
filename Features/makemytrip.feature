Feature: verifying functionalities in makemytrip portal

  Scenario: select source and destination in makemytrip
    Given user is already on home page
    When user select source and destination
    Then display source and destination on home page

  Scenario: select departure and return date
    Given user is already on home page
    When user select departure date as 10th feb and return date as 18th Feb
    Then display departure date and return date on home page

  Scenario: select passengers like adults and childrens combination
    Given user navigate to travellers and class screen from home page
    When user select 2 adults and 1 children
    Then display total number of passengers on home page

  Scenario: select low priced airlines and click book now button
    Given user navigate from home page to flights page
    When user select low price airlines
    And user click BOOK NOW button
    Then user navigate to more fares popup window

  Scenario: change premium flex from economic class and click continue
    Given user is already on more fares popup window
    When user change Premium Flex from Economic class
    And user click CONTINUE button
    Then user navigate to CompleteYourBooking window