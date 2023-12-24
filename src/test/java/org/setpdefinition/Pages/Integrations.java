package org.setpdefinition.Pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.And;
import org.Base.BaseClase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Utils.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.setpdefinition.GettingPaid;

public class Integrations extends BaseClase{
	public PropertiesReader propertiyReader =null ;
	public  static Logger log;
	public Integrations(){
		log= LogManager.getLogger(Integrations.class);
	}
	@Given("user launch the browser and Maximize the window")
	public void User_launch_the_browser_and_Maximize_the_window() throws Exception {
	    driver= launchBrowser("firefox");
	    propertiyReader=new PropertiesReader();
	    
	}
	
	@When("user Hit the Shopdot Url")
	public void user_Hit_the_Shopdot_Url() {
	    launchurl("https://qa2.shopdotapp.com/login");
	}

	@When("user Login to the Shopdot application")
	public void user_Login_to_the_Shopdot_application() {
		driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(propertiyReader.getProperty("IntgirationLogin"));
		   driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Welcome6@123");
		   driver.findElement(By.xpath("//div[@class='form-input mt-5']")).click();
		   
	}

	@When("user clicks on Integrations menu from Settings")
	public void user_clicks_on_Integrations_menu_from_Settings() throws InterruptedException {
		
//	    driver.findElement(By.xpath("//a[normalize-space()='Integrations']")).click();
	    
	    try {

			WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Integrations']"));
            // Attempt to click the element
            element.click();
            
        } catch (Exception e) {
            // Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
        	WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Integrations']"));
        	JavascriptExecutor executor = (JavascriptExecutor)driver;
        	
//            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }

	}
	    
	

	@When("Display Integrations menu page")
	public void display_Integrations_menu_page() {
	    String Integration = driver.findElement(By.xpath("//h2[normalize-space()='Integrations']")).getText();
	    assertEquals(Integration, "Integrations");
	    System.out.println("The displayed Screen is: " + Integration);

	    
	}
//003
	@When("user enter Store name")
	public void user_enter_Store_name() throws InterruptedException {

		propertiyReader=new PropertiesReader();
		System.out.println("Entred store Name: ");
		Thread.sleep(2000);
		log.info(propertiyReader.getProperty("Intgirationuser"));
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(propertiyReader.getProperty("Intgirationuser"));

	}

	@When("user click on the Connect button")
	public void user_click_on_the_Connect_button() throws InterruptedException {
		Thread.sleep(2000);
	    waituntilClickable(driver.findElement(By.xpath("//button[text()='Connect']"))).click();
	}

	@When("user should see the sucessful message on the page")
	public void user_should_see_the_sucessful_page_on_the_page() throws IOException {
	    screenShot("in");
	}

//	@Then("it should navigate to the Shopify Login page")
//	public void it_should_navigate_to_the_Shopify_Login_page() {
//	    
//	}
	@When("user Login to the Shopify")
	public void user_Login_to_the_Shopify() throws InterruptedException {
	Thread.sleep(4000);
		if(driver.getCurrentUrl().contains("/admin/oauth/authorize?")){
			waituntilClickable(driver.findElement(By.xpath("//span[text()='Sign up for Shopify']")));
		waituntilClickable(driver.findElement(By.xpath("//a[text()='Log in']")));
		}
		driver.findElement(By.xpath("//input[@id='account_email']")).sendKeys(propertiyReader.getProperty("shopifyuser"));
Thread.sleep(2000);
		waituntilClickable(driver.findElement(By.xpath("//button[@type='submit']")));
		Thread.sleep(2500);
	    driver.findElement(By.xpath("//input[@id='account_password']")).sendKeys(propertiyReader.getProperty("shopifypass"));
	    Thread.sleep(2000);
		waituntilClickable(driver.findElement(By.xpath("//button[@type='submit']")));
		Thread.sleep(5000);
		waituntilClickable(driver.findElement(By.xpath("(//button[@type='button'])[9]")));

//		driver.findElement(By.xpath("Polaris-Button__Content_xd1mk")).click();
		try {

			WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Getting Paid']"));
			// Attempt to click the element
			element.click();

		} catch (Exception e) {
			// Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
			WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Getting Paid']"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;

			executor.executeScript("arguments[0].click();", element);
		}
	}
	    

	
	@When("navigate to the shopdot Integrations screen with the status Connected")
	public void navigate_to_the_shopdot_Integrations_screen_with_the_status_Connected() throws InterruptedException {

		String connected = driver.findElement(By.xpath("//span[@class='status-pill pill_connected']")).getText();
		log.info("The status is: " + connected);
		assertEquals(connected, "Connected");
//	    assertEquals(connected.getCssValue("color"), "#2f80ed");


	    
		try {

			WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Getting Paid']"));
            // Attempt to click the element
            element.click();
            
        } catch (Exception e) {
            // Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
        	WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Getting Paid']"));
        	JavascriptExecutor executor = (JavascriptExecutor)driver;
        	
            executor.executeScript("arguments[0].click();", element);
        }
	}
	
//	001
	@When("user click on the connect button it should be Disabled")
	public void user_click_on_the_connect_button_it_should_be_Disabled() {
	    
	}

	@Then("user should see error text on below the field")
	public void user_should_see_error_text_on_below_the_field() {
	    
	}
//	002
	@When("user enter invalid store name in the field")
	public void user_enter_invalid_store_name_in_the_field() {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("testshopdot1.shopify.com");
	}

	@Then("user should see the error text {string} on below the Field")
	public void user_should_see_the_error_text_message_on_below_the_Field(String errorText) {
	    String error = driver.findElement(By.xpath("//div[@class='invalid-feedback']")).getText();
	    assertEquals(error, errorText);
	    log.info(error);
	}
//	004
	@When("user click on the Disconnect from Shopify button")
	public void user_click_on_the_Disconnect_from_Shopify_button() {
	    driver.findElement(By.xpath("//button[normalize-space()='Disconnect from Shopify']")).click();
	}

	@Then("user will see the pop-up Message on the screen")
	public void user_will_see_the_pop_up_Message_on_the_screen() {
	    String text = driver.findElement(By.xpath("//div[@class='h1']")).getText();
	    assertEquals(text, "Before you disconnect Shopify from ShopDot");
	}

	@Then("user click on the Disconnect button on the Pop-up message")
	public void user_click_on_the_Disconnect_button_on_the_Pop_up_message() {
	    driver.findElement(By.xpath("//button[normalize-space()='Disconnect']")).click();
	}

	@Then("user should see the sucessful message")
	public void user_should_see_the_sucessful_message() {
	    
	}

	@Then("user should able to see the Reconnect shopify button and display the Disconneted status")
	public void user_should_able_to_see_the_Reconnect_button_and_display_the_Disconneted_title() {
	    boolean displayed = driver.findElement(By.xpath("//button[normalize-space()='Reconnect Shopify']")).isDisplayed();
	    assertEquals(displayed, "Reconnect Shopify");
	    
	    
	    
	}
	@When("user click on the Reconnect Shopify button")
	public void user_click_on_the_Reconnect_Shopify_button() throws InterruptedException {
	    driver.findElement(By.xpath("//button[normalize-space()='Reconnect Shopify']")).click();
	    
	   
		driver.findElement(By.xpath("//input[@id='account_email']")).sendKeys();
		
		
//		driver.findElement(By.xpath("//button[@name='commit']")).click();
		
		 try {

				WebElement element = driver.findElement(By.xpath("//span[@class='ui-button__text']"));
	            // Attempt to click the element
	            element.click();
	            
	        } catch (Exception e) {
	            // Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
	        	WebElement element = driver.findElement(By.xpath("//span[@class='ui-button__text']"));
	        	JavascriptExecutor executor = (JavascriptExecutor)driver;
	        	
//	            JavascriptExecutor executor = (JavascriptExecutor) driver;
	            executor.executeScript("arguments[0].click();", element);
	        }
	    
	    
	    driver.findElement(By.xpath("//input[@id='account_password']")).sendKeys("satya1910#");  
	    
	    driver.findElement(By.xpath("//button[@name='commit']")).click();
	    
//	    try {
//
//			WebElement element = driver.findElement(By.xpath("//button[@name='commit']"));
//            // Attempt to click the element
//            element.click();
//            
//        } catch (Exception e) {
//            // Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
//        	WebElement element = driver.findElement(By.xpath("//button[@name='commit']"));
//        	JavascriptExecutor executor = (JavascriptExecutor)driver;
//        	
////            JavascriptExecutor executor = (JavascriptExecutor) driver;
//            executor.executeScript("arguments[0].click();", element);
//        }
//	    Thread.sleep(1500);
//	    driver.findElement(By.xpath("//div[@class='Polaris-Box_375yx Polaris-Box--printHidden_15ag0']//span[@class='Polaris-Button__Text_yj3uv'][normalize-space()='Add unlisted sales channel']")).click();
	       
	}

	@Then("sucessful message display on the Screen")
	public void sucessful_message_display_on_the_Screen() {
	    String msg = driver.findElement(By.xpath("")).getText();
	    assertEquals(msg, "");
	}

	@Then("user should able to see the Disconnect from Shopify button and display the Connected status")
	public void user_should_able_to_see_the_Disconnect_from_Shopify_button_and_display_the_Connected_title() {
	    String status = driver.findElement(By.xpath("//span[@class='status-pill pill_connected']")).getText();
	    assertEquals(status, "Connected");
	    System.out.println("The Shopify Status is: " + status);
	    
	    String reconnect = driver.findElement(By.xpath("//button[normalize-space()='Disconnect from Shopify']")).getText();
	    assertEquals(reconnect, "Disconnect from Shopify");
	    System.out.println("The Displaying Button is: " + reconnect);
	    
	}

	@And("user enter Existing Store name")
	public void userEnterExistingStoreName() throws InterruptedException {
		propertiyReader=new PropertiesReader();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(propertiyReader.getProperty("ExistingIntgirationuser"));
	}

	@Then("user should see the Error message {string} on the page")
	public void userShouldSeeTheErrorMessageOnThePage(String errorpopup) {
		String popup = driver.findElement(By.xpath("//div[@class='Toastify__toast-container Toastify__toast-container--top-right']")).getText();
		assertEquals(popup, errorpopup);
		log.info(popup);
	}
}
