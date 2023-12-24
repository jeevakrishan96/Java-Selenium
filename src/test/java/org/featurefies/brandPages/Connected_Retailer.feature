@CR
Feature: As a Brand, I want to be able to view the list of retailers that I have approved, so I can manage them accordingly

  @CR01
  Scenario: Displaying the Connected Retailer List
    Given user launch the browser and Maximize window
    When to hit the Shopdot Url
    And user Login to the SHOPDOT application
    When Brand clicks on "Connected Retailers" option from Retailers menu
    Then the list of approved retailers is displayed in alphabetical order by Retailer Name
    And the total number of connected retailers for that brand is displayed on the top next to Connected Retailers

  @CR02
  Scenario: Displaying Empty Approved Retailers List and Validating the "Invite Retailers" button
    Given user launch the browser and Maximize window
    When to hit the Shopdot Url
    And user Login into the SHOPDOT application
    When Brand clicks on "Connected Retailers" option from Retailers menu
    Then the following screen will be displayed: "Currently you have no connected retailers."
    And the Application displays the result count (which is 0)
    When the user click on the "Invite Retailers" buttons
    Then referral link pop Displays

  @CR03
  Scenario: Displaying Empty Approved Retailers List and Validating the "View Requests for Access" button
    Given user launch the browser and Maximize window
    When to hit the Shopdot Url
    And user Login into the SHOPDOT application
    When Brand clicks on "Connected Retailers" option from Retailers menu
    Then the following screen will be displayed: "Currently you have no connected retailers."
    And the Application displays the result count (which is 0)
    When the user click on the "View Requests for Access" buttons
    Then user should navigate to the Requests for Access Screen"Requests for Access"

  @CR04
  Scenario: Searching within Connected Retailer List
    Given user launch the browser and Maximize window
    When to hit the Shopdot Url
    And user Login to the SHOPDOT application
    Given Brand clicks on "Connected Retailers" option from Retailers menu
    When user enters characters in the search bar
    Then the Application displays only those approved retailers that match the search keyword
    And the Application displays the result count

  @CR05
  Scenario: Displaying No search results found in Connected Retailers List
    Given user launch the browser and Maximize window
    When to hit the Shopdot Url
    And user Login to the SHOPDOT application
    Given Brand clicks on "Connected Retailers" option from Retailers menu
    When Brand enters non existing Retailer name in the search bar
    Then the following message is displayed in the table "There are no approved retailers that meet your criteria"
#    And the Application displays the result count (which is 0)

    @CR06
  Scenario: Filtering Connected Retailers by Retailer Category
      Given user launch the browser and Maximize window
      When to hit the Shopdot Url
      And user Login to the SHOPDOT application
      Given Brand clicks on "Connected Retailers" option from Retailers menu
    When Brand selects retailer category as filter
#    And displays the selected filters on top of the list
    And the Application displays the result count


  @CR07
  Scenario: Filtering Connected Retailers by State
    Given user launch the browser and Maximize window
    When to hit the Shopdot Url
    And user Login to the SHOPDOT application
    Given Brand clicks on "Connected Retailers" option from Retailers menu
    When Brand selects state as filter
#    Then displays the selected filters on top of the list
    And the Application displays the result count


