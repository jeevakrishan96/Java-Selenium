@AccessRequest
Feature: As a Brand, I want to be able to view the list of retailers that requested for connect,
          so that I can review and approve/decline accordingly


  @RA01
  Scenario: Viewing Requests for Access
    Given user launch the browser and Maximize window
    When to hit the Shopdot Url
    And user Login to the SHOPDOT application
    And the retailer clicks on "Requests for Access" under Retailers main menu
    Then the Application displays the list of retailers requesting access from the brand
    And the sorting order is Pending requests followed by Connected requests and then Declined requests

  @RA02
  Scenario: Retailer Interaction with the 3-dot Menu
    Given user launch the browser and Maximize window
    When to hit the Shopdot Url
    And user Login to the SHOPDOT application
    And the retailer clicks on "Requests for Access" under Retailers main menu
    And the retailer clicks on the View or Edit button from 3dot menu
    Then it should navigate to the Retailer profile screen

  @RA03
  Scenario: Displaying Empty Requests for Access List and Validating the "Invite Retailers" button
    Given user launch the browser and Maximize window
    When to hit the Shopdot Url
    And user Login into the SHOPDOT application
    When the retailer clicks on "Requests for Access" under Retailers main menu
    Then the following screen will be display: "You currently have no requests for access from any retailer."
    And the Application displays the result count (which is 0)
    When the user click on the "Invite Retailers" buttons
    Then referral link pop Displays

  @RA04
  Scenario: Attempts to approve the request without assigning a product
    Given user launch the browser and Maximize window
    When to hit the Shopdot Url
    And user Login to the SHOPDOT application
    And the retailer clicks on "Requests for Access" under Retailers main menu
    And retailer clicks on the Retailer Profile
#    And retailer clicks on the Retailer Profile"emmanueljThree"
    And it redirect to the retailer profile screen
    And Retailer clicks on the Approve Button without assign any product
    Then it should display the error message "Assign at least one product to approve retailer"

#  Scenario: Attempts to approve the request without assigning a product
#    Given user launch the browser and Maximize window
#    When to hit the Shopdot Url
#    And user Login to the SHOPDOT application
#    And the retailer clicks on "Requests for Access" under Retailers main menu
#    And retailer clicks on the Retailer Profile"Two Emmanuel"
#    And it redirect to the retailer profile screen
#    And Retailer clicks on the Approve Button with assigning one product
#    Then it should display the error message "Assign at least one product to approve retailer"

  @RA05
  Scenario: Declining Retailer Access Request for a Pending Status
    Given user launch the browser and Maximize window
    When to hit the Shopdot Url
    And user Login to the SHOPDOT application
    And the retailer clicks on "Requests for Access" under Retailers main menu
    And Brand click the Retailer profile "DD RetailerOne"
    When Brand clicks on Decline button from Retailer Profile Screen
    Then a confirmation message will display
    When Brand clicks on "Yes" from the pop-up
    Then the brand-retailer connection request’s status is updated from "Pending" to "Declined"
#    And a success message is displayed on the screen: "<Retailer Name> has been declined access to your products"

  @RA06
  Scenario: Declining an Approved Retailer Request
    Given user launch the browser and Maximize window
    When to hit the Shopdot Url
    And user Login to the SHOPDOT application
    And the retailer clicks on "Requests for Access" under Retailers main menu
    When Brand click the Retailer profile "DD RetailerOne"
    Then the Retailer Profile Screen is displayed with an option to Decline
    When user clicks on Decline
    Then a pop-up message will displayed on the Screen
    When Brand clicks on "Yes" from the pop-up
    Then the retailer connection status is updated from "Connected" to "Declined"
    And all previously assigned products are unassigned
    And a message is displayed on the screen: "<Retailer Name> has no longer access to your products"

