Feature: Verify the Google Map

  Scenario Outline: As a user, I should be able to select source and destination verify the driving time

    Given User open the browser
    And User navigate to Google map page
    When User enter destination point "<Destination>" and press enter button
    And User click on direction
    And User enter starting point "<From>" and press enter button
    And User click on travel mode "<Travel Mode Type>"
    Then User can see fastest route option shown takes less than <Fastest Route Time> minutes

    #If It's having more data sets can read from xl file too
    Examples:
      |Destination        |From                 | Travel Mode Type      |Fastest Route Time |
      |Orchard Road       |Vivo City            | Driving               |20                 |


