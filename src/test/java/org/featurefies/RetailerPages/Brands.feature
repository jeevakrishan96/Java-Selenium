@Brands
Feature: Validating Brands Menu functionality
         As a Retailer, I want to be able to view the list of brands, so that I would know what is available for me
  
  Background:
  Given user launch the browser and Maximize window
  When to hit the Shopdot Url
  And user login to the Shopdot Application
  #And user navigated to the Dashboard screen
  #And user clicks Settings button
  And click on the Brands menu
  
  @BL001
  Scenario: Sending request to the Brand
  And the user is on the Brand Listing page
  And user select a Brands and click on the connect button  
  And displays the sucessful message "Connect Request Sent Successfully!"
  And click on the close button in the popup
  Then Status changes to "Pending"

  @BL002
  Scenario: Searching the existing Brands
  
    And the user is on the Brand Listing page
    And the user enters keyword in the search bar
    Then the Application displays only those brands in the filter that match keyword
    And the Application displays the result count
    
  @BL003
  Scenario: No Brands Matching Search Criteria
    And the user is on the Brand Listing page
    When the user enters nonexistent_keyword in the search bar
    Then the message "There are no brands that meet your criteria."is displayed in the table
    And the Application displays the result count as 0
   
  @BL004
  Scenario: Filtering Brands by Status
    And the user is on the Brand Listing page
    When the user selects "Connected" status in the filter section
    Then the Application refreshes the list to display brands with "Connected" status
    
    When the user selects "Pending" status in the filter section
    Then the Application refreshes the list to display brands with "Pending" status
    
    When the user selects "Not connected" status in the filter section
    Then the Application refreshes the list to display brands with "Not connected" status
    
    When the user selects "Declined" status in the filter section
    Then the Application refreshes the list to display brands with "Declined" status
    
    And the Application displays the result count


  @BL005
  Scenario: Filtering Brands by Brand Category
    And the user is on the Brand Listing page
    And the user selects a brand category on the top navigation bar
    And the Application refreshes the list to display brands matching the selected brand category
    Then the Application displays the result count

 
  @BL006
  Scenario: Filtering Brands by Brand Values
    And the user is on the Brand Listing page
    And the user selects brand values in the filter section
    And the Application refreshes the list to display brands that match the selected filters
    Then the Application displays the result count
 
  @BL007
  Scenario: Filtering Brands by State
    And the user is on the Brand Listing page
    And the user selects a State in the filter section
    And the Application refreshes the list to display brands that match the selected State
    Then the Application displays the result count
    
  @BL008
  Scenario: Filtering Brands by Retail Pricing
    And the user is on the Brand Listing page
    And the user selects one or more options from Retail Pricing
    And the Application refreshes the list to display brands that match the selected filter
    Then the Application displays the result count
  
  @BL009
  Scenario: No Matches for Selected Filter
    And the user is on the Brand Listing page
    And the user selects a filter
    And the Application verifies that there are no matches for the selected filter
    Then the Application displays the message: "There are no brands that match your search" on the table
  
  