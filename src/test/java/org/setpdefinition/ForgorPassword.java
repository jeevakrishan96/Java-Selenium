package org.setpdefinition;

import org.Base.BaseClase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ForgorPassword extends BaseClase{
	
	@Given("User Launch the Browser and Maximize the Window")
	public void user_Launch_the_Browser_and_Maximize_the_Window() throws Exception {
	    launchBrowser("chrome");
	}

	@When("User hit the Shopdot URL")
	public void user_hit_the_Shopdot_URL() {
	    launchurl("https://qa2.shopdotapp.com/login");
	}

	@When("User click on the Forgot Password button")
	public void user_click_on_the_Forgot_Password_button() {
	    driver.findElement(By.xpath("//a[normalize-space()='Forgot Password']")).click();
	}

	@Then("it should redirected to the Forgot Password screen")
	public void it_should_redirected_to_the_Forgot_Password_screen() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentUrl);
	    String pass = driver.findElement(By.xpath("//h1[normalize-space()='Forgot Password?']")).getText();
	    Assert.assertEquals(pass, "Forgot Password?");
	    System.out.println("The user is navigated to the: " + pass);
	    
	}
//002
	@When("redirected to the Forgot Password screen")
	public void redirected_to_the_Forgot_Password_screen() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentUrl);
	    String password = driver.findElement(By.xpath("//h1[normalize-space()='Forgot Password?']")).getText();
	    Assert.assertEquals(password, "Forgot Password?");
	    System.out.println("The user is navigated to the: " + password);
	}

	@When("leave the email address field empty and click on send Email button")
	public void leave_the_email_address_field_empty_and_click_on_send_Email_button() {
	    WebElement empty = driver.findElement(By.xpath("//input[@placeholder='Email address']"));
	   
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    
	    
	}

	@Then("it should display error text below the email field")
	public void it_should_display_error_text_below_the_email_field() {
	   String err = driver.findElement(By.xpath("")).getText();
	   Assert.assertEquals(err, "Email is required.");
	   System.out.println("The displayed error message is: " + err);
	}
	
//	003
	@When("User click on the Login link on the Forgot Password Screen")
	public void user_click_on_the_Login_link_on_the_Forgot_Password_Screen() {
	    driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	}

	@Then("User should be redirected back to the Login screen")
	public void user_should_be_redirected_back_to_the_Login_screen() {
	    String text = driver.findElement(By.xpath("//h1[normalize-space()='Log in']")).getText();
	    Assert.assertEquals(text, "Log in");
	    System.out.println("The page navigated to the: " + text);
	    
	    String currentUrl = driver.getCurrentUrl();
	    System.out.println(currentUrl);
	    
	}

}
