Feature: Validating gettingPaid menu functionality
  
  Background:
 Given user Launch the "chrome" Browser and Maximize the window
 When user launch the Shopdot URL
 And user Login to the ShopDot
 And user clicks on gettingpaid menu 
 And Display Gettingpaid menu page
 And user selects the option "no" from the Is your business a publicly traded C_Corporation or non-profit?
 And user selects the option "Yes" from the Are you an authorized signer?
 And user click on the Start Application button
 
 @GP001
   Scenario: Validating Getting Paid Business category as Single member LLC
   
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
   And user enter phone number in the Phone number field
   And user enter SSN number in the Social Security Number field
   And user select Date of birth 
   And user enter Email address
   And user enter Home Address
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
   #And user should see the account satus as pending
   
    @GP002
   Scenario: Validating Getting Paid Business category as Single member LLC choosing Tax ID Type as SSN
   
   And user enter data on the Legal name of business field
   And user enter data on the Doing business as field
   And user select option in the Business category field
   And user enter address in the Business website address field
   And user select "SINGLE_MEMBER_LLC" Type from Business category field
   And user select Tax ID Type as "Social Security Number (SSN)"
   And user enter data in the SSN field
   And user enter email in the Business email address field
   And user enter phone number in the Business phone number field
   And user enter address in the Address line1 field
   And user enetr address in the Address line2 field
   And user select country from Country field
   And user select "Alabama" sate from the select State field
   And user enter city name in the City Field
   And user enter zipcode in the ZIP field
   And user select "California" sate incorporaion from the select State field
   And user select date in the Date of incorporation field
   And user enter data in the Estimated average sales volume on ShopDot field
   And user enter data in the Estimated average wholesale price on ShopDot field
   And user select time in the Average delivery time field
   And user select code from the Merchant category code field
   And user enter data in the Product description field
   And user click on the save button 
#Business Representative
   And user enter first name in the Legal name of business representative field
   And user enter last name in the Legal name of business representative field
   And user enter phone number in the Phone number field
   And SSN number should have filled as like in the Business Details page
   And user select Date of birth 
   And user enter Email address
   And user enter Home Address
   And user select Country
   And user select State
   And user enter City name 
   And user enter ZIP
   And user selects Secondary identification
   And click on the Save and Next button 
   #Bank Details & summary
   And user enter name on the Name of the bank account holder field
   And user select Bank account type
   And user enter Account number
   And user enter Routing number
   And click on the Save and Next button
   And navigate to the summary page
   And user click on the checkbox
   And user click on the submit button
   Then pop-up will display and user click on the Close button
   #And user should see the account satus as pending
   
   @GP003
   Scenario: Select an option Sole Proprietor in the Business category field

   And user enter data on the Legal name of business field
   And user enter data on the Doing business as field
   And user select an option Sole Proprietor in the Business category field
   And user enter address in the Business website address field
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
   And user select "California" sate incorporaion from the select State field
   And user select date in the Date of incorporation field
   And user enter data in the Estimated average sales volume on ShopDot field
   And user enter data in the Estimated average wholesale price on ShopDot field
   And user select time in the Average delivery time field
   And user select code from the Merchant category code field
   And user enter data in the Product description field
   And user click on the save button
   #:Business Representative
   And user enter first name in the Legal name of business representative field
   And user enter last name in the Legal name of business representative field
   And user enter phone number in the Phone number field
   And user enter SSN number in the Social Security Number field
   And user select Date of birth 
   And user enter Email address
   And user enter Home Address
   And user select Country
   And user select State
   And user enter City name 
   And user enter ZIP
   And user selects Secondary identification
   And click on the Save and Next button
   #:Bank Details & summary
   And user enter name on the Name of the bank account holder field
   And user select Bank account type
   And user enter Account number
   And user enter Routing number
   And click on the Save and Next button
   And navigate to the summary page
   And user click on the checkbox
   And user click on the submit button
   Then pop-up will display and user click on the Close button
   #And user should see the account satus as pending
   
     @GP004
     Scenario: Select an option Sole Proprietor in the Business category field and choosing Tax ID Type as SSN
   And user enter data on the Legal name of business field
   And user enter data on the Doing business as field
   And user select an option Sole Proprietor in the Business category field
   And user enter address in the Business website address field
   And user select Tax ID Type as "Social Security Number (SSN)"
   And user enter data in the SSN field
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
#Business Representative
   And user enter first name in the Legal name of business representative field
   And user enter last name in the Legal name of business representative field
   And user enter phone number in the Phone number field
   And SSN number should have filled as like in the Business Details page
   And user select Date of birth 
   And user enter Email address
   And user enter Home Address
   And user select Country
   And user select State
   And user enter City name 
   And user enter ZIP
   And user selects Secondary identification
   And click on the Save and Next button 
   #Bank Details & summary
   And user enter name on the Name of the bank account holder field
   And user select Bank account type
   And user enter Account number
   And user enter Routing number
   And click on the Save and Next button
   And navigate to the summary page
   And user click on the checkbox
   And user click on the submit button
   Then pop-up will display and user click on the Close button
   #And user should see the account satus as pending
   
   @GP005
   Scenario: Choosing Business category as LLC
   
   And user enter data on the Legal name of business field
   And user enter data on the Doing business as field
   And user select an option LLC in the Business category field
   And user enter data in the EIN field
   And user enter website address in the Business website address field
   And user enter email in the Business email address field
   And user enter phone number in the Business phone number field
   And user enter address in the Address line1 field
   And user enetr address in the Address line2 field
   And user select country from Country field.
   And user select "Alabama" sate from the select State field
   And user enter city name in the City Field
   And user enter zipcode in the ZIP field
   And user select state from the State of incorporation field.
   And user select date in the Date of incorporation field
   And user enter data in the Estimated average sales volume on ShopDot field
   And user enter data in the Estimated average wholesale price on ShopDot field
   And user select time in the Average delivery time field
   And user select code from the Merchant category code field.
   And user enter data in the Product description field
   And user click on the save button 
   #
   And user enter first name in the Legal name of business representative field
   And user enter last name in the Legal name of business representative field
   And user enter phone number in the Phone number field
   And user enter the SSN number
   And selects the date of birth
   And user enter Email address
   And user enter Home Address line1
   And user enter the Home Address line2
   And user select the Country in Business category
   And user select the State in Business category
   And user enter the City
   And user enter the ZIP
   And user selects the Identification type
   And user select country from Country of issuance
   And user enter ID number
   And user enter Percentage ownership 
   And user click on the Save and next button
   #
   And user enter name on the Name of the bank account holder field
   And user select Bank account type
   And user enter Account number
   And user enter Routing number
   And click on the Save and Next button
   And navigate to the summary page
   And user click on the checkbox
   And user click on the submit button 
   Then pop-up will display and user click on the Close button
   #And user should see the account satus as pending
   
   @GP006
   Scenario: Choosing Business category as LLP
   And user enter data on the Legal name of business field
   And user enter data on the Doing business as field
   And user select an option LLP in the Business category field
   And user enter data in the EIN field
   And user enter website address in the Business website address field
   And user enter email in the Business email address field
   And user enter phone number in the Business phone number field
   And user enter address in the Address line1 field
   And user enetr address in the Address line2 field
   And user select the country from Country field
   And user select "Alabama" sate from the select State field
   And user enter city name in the City Field
   And user enter zipcode in the ZIP field
   And user select the state from the State of incorporation field
   And user select date in the Date of incorporation field
   And user enter data in the Estimated average sales volume on ShopDot field
   And user enter data in the Estimated average wholesale price on ShopDot field
   And user select time in Average delivery time field
   And user select the code from  Merchant category code field
   And user enter data in the Product description field
   And user click on the save button 
   #
   And user enter first name in the Legal name of business representative field
   And user enter last name in the Legal name of business representative field
   And user enter phone number in the Phone number field
   And user enter the SSN number
   And selects the date of birth
   And user enter Email address
   And user enter Home Address line1
   And user enter the Home Address line2
   And user selects the Country
   And user selects the State
   And user enter the City
   And user enter the ZIP
   And user selects the Identification type
   And user select country from Country of issuance
   And user enter ID number
   And user enter Percentage ownership 
   And user click on the Save and next button
   #
   And user enter name on the Name of the bank account holder field
   And user select Bank account type
   And user enter Account number
   And user enter Routing number
   And click on the Save and Next button
   And navigate to the summary page
   And user click on the checkbox
   And user click on the submit button
   Then pop-up will display and user click on the Close button
   #And user should see the account satus as pending
   
   @GP007
   Scenario: Choosing Business category as Partnership
   
   And user enter data on the Legal name of business field
   And user enter data on the Doing business as field
   And user select an option Partnership in the Business category field
   And user enter data in the EIN field
   And user enter website address in the Business website address field
   And user enter email in the Business email address field
   And user enter phone number in the Business phone number field
   And user enter address in the Address line1 field
   And user enetr address in the Address line2 field
   And user selects country from Country field
   And user select "Alabama" sate from the select State field
   And user enter city name in the City Field
   And user enter zipcode in the ZIP field
   And user selects state from the State of incorporation field
   And user select date in the Date of incorporation field
   And user enter data in the Estimated average sales volume on ShopDot field
   And user enter data in the Estimated average wholesale price on ShopDot field
   And user selects time in the Average delivery time field
   And user selects code from the Merchant category code field
   And user enter data in the Product description field
   And user click on the save button 
   #
   And user enter first name in the Legal name of business representative field
   And user enter last name in the Legal name of business representative field
   And user enter phone number in the Phone number field
   And user enter the SSN number
   And selects the date of birth
   And user enter Email address
   And user enter Home Address line1
   And user enter the Home Address line2
   And user selects the Country
   And user selects the State
   And user enter the City
   And user enter the ZIP
   And user selects the Identification type
   And user select country from Country of issuance
   And user enter ID number
   And user enter Percentage ownership 
   And user click on the Save and next button
   #
   And user enter name on the Name of the bank account holder field
   And user select Bank account type
   And user enter Account number
   And user enter Routing number
   And click on the Save and Next button
   And navigate to the summary page
   And user click on the checkbox
   And user click on the submit button
   Then pop-up will display and user click on the Close button
   #And user should see the account satus as pending
   
   @GP008
   Scenario: Choosing Business category as S_CORP
   
   And user enter data on the Legal name of business field
   And user enter data on the Doing business as field
   And user select an Option S_CORP in the Business category field
   And user enter data in the EIN field
   And user enter website address in the Business website address field
   And user enter email in the Business email address field
   And user enter phone number in the Business phone number field
   And user enter address in the Address line1 field
   And user enetr address in the Address line2 field
   And user selects country from Country field
   And user select "Alabama" sate from the select State field
   And user enter city name in the City Field
   And user enter zipcode in the ZIP field
   And user selects state from the State of incorporation field
   And user select date in the Date of incorporation field
   And user enter data in the Estimated average sales volume on ShopDot field
   And user enter data in the Estimated average wholesale price on ShopDot field
   And user selects time in the Average delivery time field
   And user selects code from the Merchant category code field
   And user enter data in the Product description field
   And user click on the save button 
   #
   And user enter first name in the Legal name of business representative field
   And user enter last name in the Legal name of business representative field
   And user enter phone number in the Phone number field
   And user enter the SSN number
   And selects the date of birth
   And user enter Email address
   And user enter Home Address line1
   And user enter the Home Address line2
   And user selects the Country
   And user selects the State
   And user enter the City
   And user enter the ZIP
   And user selects the Identification type
   And user select country from Country of issuance
   And user enter ID number
   And user enter Percentage ownership 
   And user click on the Save and next button
   #
   And user enter name on the Name of the bank account holder field
   And user select Bank account type
   And user enter Account number
   And user enter Routing number
   And click on the Save and Next button
   And navigate to the summary page
   And user click on the checkbox
   And user click on the submit button
   Then pop-up will display and user click on the Close button
   #And user should see the account satus as pending
   
   @GP009
   Scenario: Choosing Business category as C_CORP - Not Publicly Traded
   
   And user enter data on the Legal name of business field
   And user enter data on the Doing business as field
   And user select an Option C_CORP - Not Publicly Traded in the Business category field
   And user enter data in the EIN field
   And user enter website address in the Business website address field
   And user enter email in the Business email address field
   And user enter phone number in the Business phone number field
   And user enter address in the Address line1 field
   And user enetr address in the Address line2 field
   And user selects country from Country field
   And user select "Alabama" sate from the select State field
   And user enter city name in the City Field
   And user enter zipcode in the ZIP field
   And user selects state from the State of incorporation field
   And user select date in the Date of incorporation field
   And user enter data in the Estimated average sales volume on ShopDot field
   And user enter data in the Estimated average wholesale price on ShopDot field
   And user selects time in the Average delivery time field
   And user selects code from the Merchant category code field
   And user enter data in the Product description field
   And user click on the save button 
   #
   And user enter first name in the Legal name of business representative field
   And user enter last name in the Legal name of business representative field
   And user enter phone number in the Phone number field
   And user enter the SSN number
   And selects the date of birth
   And user enter Email address
   And user enter Home Address line1
   And user enter the Home Address line2
   And user selects the Country
   And user selects the State
   And user enter the City
   And user enter the ZIP
   And user selects the Identification type
   And user select country from Country of issuance
   And user enter ID number
   And user enter Percentage ownership 
   And user click on the Save and next button
   #
   And user enter name on the Name of the bank account holder field
   And user select Bank account type
   And user enter Account number
   And user enter Routing number
   And click on the Save and Next button
   And navigate to the summary page
   And user click on the checkbox
   And user click on the submit button
   Then pop-up will display and user click on the Close button
   #And user should see the account satus as pending

   







   

   
