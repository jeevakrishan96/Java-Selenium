
Feature: Validating Users Menu functionality 
  
  Background:
  Given user launch the browser and Maximize window
  #When to hit the Shopdot Url
  And user login to the Shopdot Application
  And user navigated to the Dashboard screen
  And user clicks Settings button
  And click on the Users menu


  @UP_001
  Scenario: To validate Users Page without entering Data
  And user click on the Add new user button
  And display User Info screen
  And click the Save button
  Then user should view the validation error message on the each fields

  
  @UP_002
  Scenario: Adding new Users
    And user click on the Add new user button
    And display User Info screen
    And Enter First name
    And Enter Last name
    And enter Email address
    And Click on the Save button
    Then displays Pop-up message and user click on the close button
    
    

  