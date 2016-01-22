Feature: Test Triangle Testing app SignUp page functionality

  @signuppage
  Scenario Outline: Launch SignUp page
    Given User is in Signup Page on "<browser>"
    When User enter forename in signup page
    And User enter surname
    And User select gender
    And User enter address
    And User enter city
    And User enter postal code
    And User enter Telephone
    And User select country
    And User Click on Submit button
    Then User successfully go to Booking page

   Examples:
    | browser |
    |   FF    |
    |   GC    |
    |   IE    |