
Feature: Forgot Password Functionality Verification


  @FP_001
  Scenario: Verify whether user is able to redirect to forget password screen on clicking Forgot password link from logIn screen.
    Given User Launch the Browser and Maximize the Window
    When User hit the Shopdot URL
    And User click on the Forgot Password button 
    Then it should redirected to the Forgot Password screen

  @FP_002
  Scenario: Attempt to Send Email with Empty Email Address
    Given User Launch the Browser and Maximize the Window
    When User hit the Shopdot URL
    And User click on the Forgot Password button
    And redirected to the Forgot Password screen
    And leave the email address field empty and click on send Email button
    Then it should display error text below the email field
   
    @FP_003
    Scenario: Return to Login page from Forgot Password Screen
    Given User Launch the Browser and Maximize the Window
    When User hit the Shopdot URL
    And User click on the Forgot Password button
    And redirected to the Forgot Password screen
    And User click on the Login link on the Forgot Password Screen
    Then User should be redirected back to the Login screen
    
    @FP_004
    Scenario: Verify Email Sending to Registered Valid Email Address
    Given User Launch the Browser and Maximize the Window
    When User hit the Shopdot URL
    And User click on the Forgot Password button
    And redirected to the Forgot Password screen
    And User Enter valid email address and click on send mail
    Then the email should be successfully sent
    And the recipient should receive the email

    
 

    
