Feature: Test Triangle Testing app Flight Booking functionality

  @bookingpage
  Scenario Outline: Launch Flight Booking page
    Given User is in Booking Page on "<browser>"
    When User select departure city in booking page
    And User select departure date
    And User select arrival city
    And User select return date
    And User enter number of passengers
    And User select round trip
    And User select Seating Preference
    And User select type of ticket
    And User Click on confirm button
    Then User successfully go to payment page

    Examples:
    | browser |
    |   FF    |
    |   GC    |
    |   IE    |