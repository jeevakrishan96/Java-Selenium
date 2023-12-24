Feature: Validating Integrations menu functionality
  
  Background:
 Given user launch the browser and Maximize the window
 When to hit the Shopdot Url
 And user Login to the Shopdot application
 And user clicks on Integrations menu from Settings
 And Display Integrations menu page
 
 @IP001
 Scenario: Validating the Connect button is Disabled on the Integrations page 
 And user click on the connect button it should be Disabled
 Then user should see error text on below the field 
 
 @IP002
 Scenario: Validating Integrations page with entering invalid Store Name 
 And user enter invalid store name in the field
 Then user should see the error text "Please only enter the name of your store." on below the Field
 
 @IP003
 Scenario: Validating Integrations page with entering valid Store Name
 And user enter Store name 
 And user click on the Connect button
 And user should see the sucessful message on the page 
# Then it should navigate to the Shopify Login page
 And user Login to the Shopify
 And navigate to the shopdot Integrations screen with the status Connected
 
  @IP004
  Scenario: Disconnect store from the ShopDot
  And user click on the Disconnect from Shopify button
  Then user will see the pop-up Message on the screen
  And user click on the Disconnect button on the Pop-up message
  And user should see the sucessful message
  And user should able to see the Reconnect shopify button and display the Disconneted status
  
  @IP005
  Scenario: reconnecting the store from shopify
  And user click on the Reconnect Shopify button
  Then sucessful message display on the Screen
  And user should able to see the Disconnect from Shopify button and display the Connected status

  @IP006
  Scenario: Validating with existing store name
   And user enter Existing Store name
   And user click on the Connect button
   Then user should see the Error message "This shop already exists with another user. Please try with a different shop" on the page
  

