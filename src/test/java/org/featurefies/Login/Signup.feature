
Feature: To validate the singup functionality of Shopdot Application
  
    Background:
    Given user launch the browser and Maximize window
    When To launch the Shopdot URL
    
    @TC_Su001
    Scenario: Login with Valid Credential 
    And User has to pass the data "Testsample" in the firstName field
    And User has to pass the data "two" in the lastName field
    And User has to pass the data "testsample2@yopmail.com" in the email field
    And User has to pass the data "Welcome6@123" in the password field
    And User clicked on checkbox button
    And User has to click on the Signup button
    Then User should navigate to the Verify Your Email page
    But user should not be in Signup Page
        
    @TC_Su002
    Scenario Outline: validate the postive and nagative combination of Signup functionality page

    And User has to pass the data "<FirstName>" in the firstName field
    And User has to pass the data "<LastName>" in the lastName field
    And User has to pass the data "<Email>" in the email field
    And User has to pass the data "<Password>" in the password field
    And User clicked on checkbox button
    And User has to click on the Signup button
    Then close the browser
    

    Examples: 
      | FirstName  | LastName | Email                       | Password             |
      | Mark       |   Antony | markantony@yopmail.com      |   Welcome6@123       |
      | William    |   $3&?.. | williamhendry@yopmail.com   |   welcome6@123       |
      | 12333      |   Hendry | williamhendry@yopmail.com   |   welcome6@123       |

     
     @TC_Su003
     Scenario: Validate wheather able to signup without enter details
     And To check wheather Signup button is enable or Disable
     Then close the browser
     
     @TC_Su004
     Scenario Outline: Validate with the Email that is already registered
     
    And User has to pass the data "<FirstName>" in the firstName field
    And User has to pass the data "<LastName>" in the lastName field
    And User pass the Existing email "<Email>" in the email field
    And User has to pass the data "<Password>" in the password field
    And User clicked on checkbox button
    And User has to click on the Signup button
    Then User should see error text 
    But User should not navigate to the Verify Your Email page
    #Then close the browser
    
    Examples: 
      | FirstName  | LastName | Email                       | Password             |
      | Magesh     |   Hendry | joshva11@yopmail.com        |   Welcome6@123       |
      | William    |Bhuvanesh | joshva15@yopmail.com        |   welcome6@123       |
     


    
     

