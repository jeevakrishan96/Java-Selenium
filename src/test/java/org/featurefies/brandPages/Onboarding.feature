
@onboarding
Feature: Validating the Onboarding
#	Scenario: Login with Valid Credential 
#	  Given User has to launch the browser and maximise the window
    #When To launch the Shopdot URL
    #And User has to pass the data "Testsample" in the firstName field
    #And User has to pass the data "Testexample" in the lastName field
    #And User has to pass the data "anything@cnaqrgng.mailosaur.net" in the email field
    #And User has to pass the data "Welcome6@123" in the password field
    #And User clicked on checkbox button
    #And User has to click on the Signup button
    #Then User should navigate to the Verify Your Email page
    #But user should not be in Signup Page
    

	Scenario: Login with Valid Credential
		Given user Launch the "chrome" Browser and Maximize the window
    When To launch the Shopdot URL
	  And User enter the valid EmailId in the emailid field
    And User enter the Valid Password in the Password field
    And User clicks on the SignIn button
    
#	 Scenario: Update Brand Profile Page
	 And user enter company name on the Company name field
	 And user enter email on the Contact email field
	 And user enter phone numer in the Contact phone number field
	 And user upload the logo in the Upload logo field
	 And user enter brand name in the Brand name filed
	 And user enter website in the Brand website field
	 And user selects three Brand category from the Brand category field
	 And user selects Brand values from the Brand values field
	 And user enters data in the About the brand field box
	 And user enters link in the Add a Youtube or Vimeo video link field
	 And user click on the Save button
	 And User is automatically moved to the next page, which is Prefernces Page
#	 Then user should see the Sucessful message
	
#	Scenario: updating Data in the Preferences Page
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
	    
#	     Scenario: Validating Integrations page with entering valid Store Name
	 And user enter Store name 
	 And user click on the Connect button
	 And user should see the sucessful message on the page 
	 #Then it should navigate to the Shopify Login page 
	 And user Login to the Shopify
	 And navigate to the shopdot Integrations screen with the status Connected
#

#	Scenario: Validating Getting Paid Business category as Single member LLC
		And Display Gettingpaid menu page
		And user selects the option "no" from the Is your business a publicly traded C_Corporation or non-profit?
		And user selects the option "Yes" from the Are you an authorized signer?
		And user click on the Start Application button
		And user enter data on the Legal name of business field
		And user enter data on the Doing business as field
		And user select option in the Business category field
		And user enter address in the Business website address field
		And user select "SINGLE_MEMBER_LLC" Type from Business category field
		And user select Tax ID Type as "Employer Identification Number (EIN)"
		And user enter data in the EIN field
		And user enter email in the Business email address field
		And user enter phone number in the Business phone number field
		And user enter address in the Address line1 field
		And user enetr address in the Address line2 field
		And user select country from Country field
		And user select "Alabama" sate from the select State field
		And user enter city name in the City Field
		And user enter zipcode in the ZIP field
		And user select state from the State of incorporation field
		And user select date in the Date of incorporation field
		And user enter data in the Estimated average sales volume on ShopDot field
		And user enter data in the Estimated average wholesale price on ShopDot field
		And user select time in the Average delivery time field
		And user select code from the Merchant category code field
		And user enter data in the Product description field
		And user click on the save button
   #Scenario:
		And user enter first name in the Legal name of business representative field
		And user enter last name in the Legal name of business representative field
		And user enter phone numer in the Phone number field
		And user enter SSN numer in the Social Security Number field
		And user select Date of birth
		And user enter Email address
		And user eneter Home Address
		And user select Country
		And user select State
		And user enter City name
		And user enter ZIP
		And user selects Secondary identification
		And click on the Save and Next button
   #Scenario:
		And user enter name on the Name of the bank account holder field
		And user select Bank account type
		And user enter Account number
		And user enter Routing number
		And click on the Save and Next button
		And navigate to the summary page
		And user click on the checkbox
		And user click on the submit button
		Then pop-up will display and user click on the Close button

#	  Scenario: Validating the Plans Functionality by choosing Growth Plan for the new user
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
	    
	    