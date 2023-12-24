Feature: Validating Retailer Profile Functionality 
In order to test rhe Retailer Profile Functionality
As a register or Authorized user
I want to update the details

Background: 
Given User Launch the Browser and Maximize the Window
When User hit the Shopdot URL
And User Login to the ShopDot Application
#And User navigate to the Getting Started Screen
#And User Click on the Setting button
And Display the Retailer Profile Menu Page 

@RP001
Scenario: Updating the Retailer Profile Page for new user

And user enter Company name in Company name field
And user enter the email in the Contact email field
And user phone number in the Contact phone number field
And user uplod the logo
And user enter the Retailer name
And user enter website on the Retailer website field
And user slect one option from the Retailer category field 
And user select Retailer values
And enter data on the About the retailer field
And user enter the link on the Add a Youtube or Vimeo video link field
And user upload the store photo
And user enter address
And user select the Country
And user select the State
And user enter City
And user enter ZIP
And user click on the Save button 
Then user should able to see the sucessful message on the Page

@RP002
Scenario: 


