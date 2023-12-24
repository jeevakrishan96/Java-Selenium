
Feature: Validating Preference menu functionality
  
  Background:
 Given user launch the browser and Maximize window
 When to hit the Shopdot Url
 And user Login to the shopdot application
 #And user navigated to the onboarding
 And user clicks on Preferences menu from Settings
 And Display Preferences menu page
 

  @PF_001
  Scenario: To validate Preferences menu Page without entering Data
  
    And wherein the Wholesale Pricing field shows default is value50% 
    And wherein the Inventory Buffer field shows default is value70%
    And wherein the Retail Pricing field selects "Enforce retail price" by default
    And wherein the Return and Refund Policy selected by default "Returns and refunds are accepted on a case-by-case basis"
    And user clicks on the Save button without enter any data on the mandatory field
    Then user should see the validation error message below the fields
    And User should not move to the next page

  @PF_002
  Scenario: updating Data in the Preferences Page
  
    And wherein the Wholesale Pricing field shows default is value50% 
    And wherein the Inventory Buffer field shows default is value70%
    And wherein the Retail Pricing field selects "Enforce retail price" by default
    And wherein the Return and Refund Policy selected by default "Returns and refunds are accepted on a case-by-case basis"
    And user enter data on  the Requirements for retailers who want to connect with your brand field
    And user enter address in the Address1 field
    And user selects Country from the Country field
    And user selects State from the State field
    And user enter city name on the City field
    And user enter data on the Zip field 
    And user enter data in the Shipping fee field
    And user enter data in the Incremental fee field
    And user selects days from the Days to fulfill field 
    And user click in the Save button on preferences page
    And User is automatically moved to the next page, which is Integrations
    Then user should see the Sucessful message in the page

  @PF_002
  Scenario:
    

    
