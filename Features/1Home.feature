Feature: Test Triangle Testing app Home page functionality

  @homepage
  Scenario Outline: Launch Test Triangle App
    Given User is in Home Page on "<browser>"
    When User Click on Checkbox
    And User Click on Next button
    Then User successfully go to Signup page

    
    Examples:
    | browser |
    |   FF    |
    |   GC    |
    |   IE    |