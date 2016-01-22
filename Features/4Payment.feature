Feature: Test Triangle Testing app Payment functionality

  @paymentpage
  Scenario Outline: Launch Payment page
    Given User is in payment Page on "<browser>"
    When User enter a credit card number in booking page
    And User enter a name on card
    And User select expiry date
    And User select cvc number
    And User Click on paynow button
    Then User successfully go to conformation page
    
    Examples:
    | browser |
    |   FF    |
    |   GC    |
    |   IE    |