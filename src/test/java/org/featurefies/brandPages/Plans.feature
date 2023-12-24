@focus
Feature: Validating Plans Page Functionality

Background:
Given user lauch the browser and Maximize the Window
When to hit the Shopdot Url
And user login to the ShopDot Application
And user click on the Plans Menu button
And Displays the Subscription Plans Screen

 #@PP001
 #Scenario: Validating Annual Subscription Plans by choosing Growth Plan

 
 @PP001
 Scenario: Validating the Plans Functionality by choosing Starter Plan for the new user
 
 And user click on the Select Plan button on the Starter 
 Then user should see the popup message on the screen
 And user click on the confirm button 
 And display Pop-up message and user clicks side arrow button
 And user click on the lets go button
 And user will be taken to the next step in onboarding (Products Page)

  @PP002
  Scenario: Validating the Plans Functionality by choosing Growth Plan for the new user
  
  And user click on the Select Plan button on the Growth a confirmation window appears with a field to enter credit card information   
  And user enter First Name
  And user enter Last Name
  And user enter Phone number
  And user enter Card number
  And user enter Card Expiry date
  And user enter Card CVV number
  And user enter Billing address
  And user select the country
  And user select the state
  And user enter the city 
  And user the ZIP
  And user click on the Submit button
  Then display Pop-up message and user clicks side arrow button
  And user click on the lets go button
  And user will be taken to the next step in onboarding (Products Page)
  
  @PP003
  Scenario: Validating the Plans Functionality by choosing Scale Plan for the new user
  And user click on the Select Plan button on the Scale and a confirmation window appears with a field to enter credit card information
  And user enter First Name
  And user enter Last Name
  And user enter Phone number
  And user enter Card number
  And user enter Card Expiry date
  And user enter Card CVV number
  And user enter Billing address
  And user select the country
  And user select the state
  And user enter the city 
  And user the ZIP
  And user click on the Submit button
  Then display Pop-up message and user clicks side arrow button
  And user click on the lets go button
  And user will be taken to the next step in onboarding (Products Page)
  
  @PP004
  Scenario: Checking close button is working on the Select plan Screen for exiting account 
  And user click on the Select plan button 
  



  
  