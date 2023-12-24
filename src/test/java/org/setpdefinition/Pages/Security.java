package org.setpdefinition.Pages;

import org.Base.BaseClase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.pojo.pojoSignInpage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Security extends BaseClase{
	private String security;

	@Given("user Lauch the browser and Maximize the Window")
	public void user_Lauch_the_browser_and_Maximize_the_Window() throws Exception {
	    driver= launchBrowser("chrome");
	}

	@When("user hit the ShopDot URL")
	public void user_hit_the_ShopDot_URL() {
	    launchurl("https://qa2.shopdotapp.com/login");
	}

	@When("user login to the ShopDot application")
	public void user_login_to_the_ShopDot_application() throws InterruptedException {
		Thread.sleep(1000);
		pojoSignInpage j =new pojoSignInpage(driver);
		sendText(j.getEmail(), "shopdottesting001@yopmail.com");
		sendText(j.getPassword(), "Welcome6@123");
		clickBtn(j.getLogin());
		
		 try {

				WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Settings']"));
	           // Attempt to click the element
	           element.click();
	           
	       } catch (Exception e) {
	           // Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
	       	WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Settings']"));
	       	JavascriptExecutor executor = (JavascriptExecutor)driver;
	       	
//	           JavascriptExecutor executor = (JavascriptExecutor) driver;
	           executor.executeScript("arguments[0].click();", element);
	       }
		
		
	}

	@When("user clicks on the Security Menu button")
	public void user_clicks_on_the_Security_Menu_button() {
	    
	    try {

			WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Security']"));
           // Attempt to click the element
           element.click();
           
       } catch (Exception e) {
           // Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
       	WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Security']"));
       	JavascriptExecutor executor = (JavascriptExecutor)driver;
       	
//           JavascriptExecutor executor = (JavascriptExecutor) driver;
           executor.executeScript("arguments[0].click();", element);
       }
	}

	@When("Displays the Security Screen")
	public void displays_the_Security_Screen() {
	   String security = driver.findElement(By.xpath("//h2[normalize-space()='Change Password']")).getText();
	    Assert.assertEquals(security, "Change Password"); 

	    System.out.println("The Displaying Screen is: " +security+ " Screen");
	}

	@When("Click on the Save button")
	public void click_on_the_Save_button() {
	    driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	}

	@Then("error message display on the below the all fields")
	public void error_message_display_on_the_below_the_all_fields() {
	    String error = driver.findElement(By.xpath("//div[@class='form-input mb-4']//small[@class='invalid-feedback mb-0'][normalize-space()='Password is required.']")).getText();
	    Assert.assertEquals(error, "Password is required.");
	    System.out.println(error);
	  
	    String NPerror = driver.findElement(By.xpath("//div[contains(@class,'form-input mb-4 password-tooltip')]//small[contains(@class,'invalid-feedback mb-0')][normalize-space()='Password is required.']")).getText();
	    Assert.assertEquals(NPerror, "Password is required.");
	    System.out.println(NPerror);
	    
	    String conferror = driver.findElement(By.xpath("//small[normalize-space()='Password confirm is required.']")).getText();
	    Assert.assertEquals(conferror, "Password confirm is required.");
	    System.out.println(conferror);


	}	
//	002
	@When("Enter the Old password")
	public void enter_the_Old_password() {
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Welcome6@123");
	}

	@When("Enter the New password")
	public void enter_the_New_password() {
	    driver.findElement(By.xpath("//input[@name='newpassword']")).sendKeys("Welcome6@321");
	}

	@When("Enter the Confirm new password")
	public void enter_the_Confirm_new_password() {
	    driver.findElement(By.xpath("//input[@name='confirmNewPassword']")).sendKeys("Welcome6@321");
	}

	@Then("Sucessful message displayed")
	public void sucessful_message_displayed() {
		String suc = driver.findElement(By.xpath("//div[@id='1']")).getText();
		Assert.assertEquals(suc, "Updated password saved!");
		System.out.println(suc);
		

	}
		
	
//	003
	@When("Enter an incorrect password on the Confirm new password field")
	public void enter_an_incorrect_password_on_the_Confirm_new_password_field() {
	    driver.findElement(By.xpath("")).sendKeys("");
	}

	@When("Enter a valid New password")
	public void enter_a_valid_New_password() {
		driver.findElement(By.xpath("")).sendKeys("");
	}

	@Then("error message display on the below the Confirm new password field")
	public void error_message_display_on_the_below_the_Confirm_new_password_field() {
	    
	}
//	004
	@When("Enter a new password that does not meet the strength criteria")
	public void enter_a_new_password_that_does_not_meet_the_strength_criteria() {
		driver.findElement(By.xpath("")).sendKeys("");
	}

	@Then("System displays an error message prompting for a stronger password")
	public void system_displays_an_error_message_prompting_for_a_stronger_password() {
	    
	}
}
