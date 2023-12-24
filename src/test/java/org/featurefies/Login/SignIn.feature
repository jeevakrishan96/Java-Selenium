
Feature: To Validate the login Functionality of Shopdot

Background:
    Given user launch the browser and Maximize window
    When To launch the Shopdot URL

   @TC001
   Scenario: To validate SignIn page wheather the signIn button is enable or disable
    And check wheather SignIn button is enable or Disable
    Then To close the Browser
    
    @TC002
    Scenario Outline: To validate the postive and nagative combination of SignIn Functionality  
    And User has to pass the data "<Email>" in the Email field
    And User has to Pass the data "<Password>" in the Password field
    And User has to click on the SignIn button
    Then close the browser
    
    Examples:
    |Email               |Password    |
    |j1oshva@yopmail.com |welcome6@123|
    |joshva1@yopmail.com |Welcome6@123|
    
    @TC003
    Scenario: Login with Valid Credential
    And User enter the valid EmailId "<joshva1@yopmail.com>" in the emailid field
    And User enter the Valid Password "<Welcome6@123>" in the Password field
    And User clicks on the SignIn button
    Then User should navigate to Dasboard Page
     

