
Feature: Validating Security Page Functionality

  Background:
#Given user launch the browser and Maximize window
#When to hit the Shopdot Url
And user login to the ShopDot application
And user clicks on the Security Menu button
And Displays the Security Screen

  @SP_001
  Scenario: To validate Security Page without entering Data
  And Click on the Save button 
  Then error message display on the below the all fields
  
  @SP_002
  Scenario: Successful Password Change
  And Enter the Old password 
  And Enter the New password
  And Enter the Confirm new password
  And Click on the Save button
  Then Sucessful message displayed
  
  @SP_003
  Scenario: Incorrect Confirm new  Password
  And Enter the Old password
  And Enter an incorrect password on the Confirm new password field
  And Enter a valid New password
  Then error message display on the below the Confirm new password field
  
  @SP_004
  Scenario: Weak New Password
  And Enter the Old password
  And Enter a new password that does not meet the strength criteria
  Then System displays an error message prompting for a stronger password 
  
  

 

  

 
