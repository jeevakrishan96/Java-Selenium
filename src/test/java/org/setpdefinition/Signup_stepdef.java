package org.setpdefinition;

import java.util.Set;

import org.Base.BaseClase;
import org.openqa.selenium.By;
import org.pojo.pojoSignupPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Signup_stepdef extends BaseClase{
pojoSignupPage p;
	@Given("User has to launch the browser and maximise the window")
	public void user_has_to_launch_the_browser_and_maximise_the_window() throws Exception {
	   driver= launchBrowser("chrome");
	    windowMax();
	}
	@When("to launch the Shopdot URL")
	public void to_launch_the_Shopdot_URL() {
	    launchurl("https://qa2.shopdotapp.com/signup/MDAwMDAwMDY");
	}

	@When("User has to pass the data {string} in the firstName field")
	public void user_has_to_pass_the_data_in_the_firstName_field(String string) {
	    pojoSignupPage p = new pojoSignupPage();
	    sendText(p.getFirstname(), string);
	}

	@When("User has to pass the data {string} in the lastName field")
	public void user_has_to_pass_the_data_in_the_lastName_field(String string) {
		p = new pojoSignupPage();
		sendText(p.getLastname(), string);
	}

	@When("User has to pass the data {string} in the email field")
	public void user_has_to_pass_the_data_in_the_email_field(String string) {
		p = new pojoSignupPage();
		sendText(p.getEmailaddress(), string);
	}

	@When("User has to pass the data {string} in the password field")
	public void user_has_to_pass_the_data_in_the_password_field(String string) {
		p = new pojoSignupPage();
		sendText(p.getEnterpassword(), string);
	}

	@When("User clicked on checkbox button")
	public void user_clicked_on_checkbox_button() {
		p = new pojoSignupPage();
		clickBtn(p.getCheckbox());
	}

	@When("User has to click on the Signup button")
	public void user_has_to_click_on_the_Signup_button() {
//		p = new pojoSignupPage();
//		clickBtn(p.getSignupbutton());
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
//		driver.switchTo().window(null)
	}
	
	@Then("User should navigate to the Verify Your Email page")
	public void user_should_navigate_to_the_Verify_Your_Email_page() {
	   
	}

	@When("To check wheather Signup button is enable or Disable")
	public void to_check_wheather_Signup_button_is_enable_or_Disable() {
	    boolean si = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
	    System.out.println(si);
	}
	
	@When("User pass the Existing email {string} in the email field")
	public void user_pass_the_Existing_email_in_the_email_field(String string) {
		p = new pojoSignupPage();
		sendText(p.getEmailaddress(), string);
	}

	@Then("User should see error text")
	public void user_should_see_error_text() {
	    
	}

	@Then("User should not navigate to the Verify Your Email page")
	public void user_should_not_navigate_to_the_Verify_Your_Email_page() {
	    
	}
	

	@Then("user should not be in Signup Page")
	public void user_should_not_be_in_Signup_Page() {
	   
	}


}
