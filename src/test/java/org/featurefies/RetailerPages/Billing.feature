
@tag
Feature: As a Retailer, I want to be able to configure my billing information 
      so that I could ShopDot could hold my account for orders and payment for transaction fees
   
   Background:
   Given retailer Launch the Browser and Maximize the Window
    When retailer hit the Shopdot URL
    And retailer Login to the ShopDot Application
    And User Click on the Setting button

  @RB01
  Scenario: Initial state without billing setup 
    And click on the billing menu
    And retailer click on the Add new credit card
    And displays Add new credit card screen 
    And retailer enter firstname
    And enter lastname
    And enter Phone number
    And enter Card number
    And enter Expiration date
    And enter CVV number
    And enter Billing address
    And retailer selects Country
    And retailer selects the State
    And retailer enter City
    And retailer enter ZIP
    And click on the save button
    Then redirect to the main screen

 
