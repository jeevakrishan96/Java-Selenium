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

public class Users extends BaseClase{
	
	@Given("User Launch the browser and Maximize window")
	public void user_Launch_the_browser_and_Maximize_window() throws Exception {
		launchBrowser("chrome");
	    windowMax();
	}

	@When("user hit the Shopdot Url")
	public void user_hit_the_Shopdot_Url() {
		launchurl("https://qa2.shopdotapp.com/login");
	}
	@When("user login to the Shopdot Application")
	public void user_login_to_the_Shopdot_Application() {
		pojoSignInpage j =new pojoSignInpage(driver);
		sendText(j.getEmail(), "joshva2@yopmail.com");
		sendText(j.getPassword(), "Welcome6@123");
		clickBtn(j.getLogin());
	}
	@When("user navigated to the Dashboard screen")
	public void user_navigated_to_the_Dashboard_screen() {
	    
	    String currentUrl = driver.getCurrentUrl();
//	    Assert.assertEquals("https://qa2.shopdotapp.com/dashboard",currentUrl);
	    System.out.println("The Navigated Screen URL is: " + currentUrl);
	}

	@When("user clicks Settings button")
	public void user_clicks_Settings_button() {
		try {

			WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Settings']"));
           // Attempt to click the element
           element.click();
           
       } catch (Exception e) {
           // Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
       	WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Settings']"));
       	JavascriptExecutor executor = (JavascriptExecutor)driver;
       	
//           JavascriptExecutor executor = (JavascriptExecutor) driver;
           executor.executeScript("arguments[0].click();", element);
       }
		
	    
	}

	@When("click on the Users menu")
	public void click_on_the_Users_menu() {
	    driver.findElement(By.xpath("//a[normalize-space()='Users']")).click();
	}

	@When("user click on the Add new user button")
	public void user_click_on_the_Add_new_user_button() {
	    driver.findElement(By.xpath("//button[@class='button button-border add-user']")).click();
	}

	@When("display User Info screen")
	public void display_User_Info_screen() {
	    String Info = driver.findElement(By.xpath("//h2[normalize-space()='User Info']")).getText();
	    Assert.assertEquals(Info, "User Info");
	    System.out.println(Info);
	}
	

	@When("click the Save button")
	public void click_the_Save_button() {
	    driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	}

	@Then("user should view the validation error message on the each fields")
	public void user_should_view_the_validation_error_message_on_the_each_fields() {
		String firsterror = driver.findElement(By.xpath("//small[normalize-space()='First name is required.']")).getText();
		Assert.assertEquals(firsterror, "First name is required.");
		System.out.println("The error message below the FirstName Field is: " + firsterror);
		String lasterror = driver.findElement(By.xpath("//small[normalize-space()='Last name is required.']")).getText();
		Assert.assertEquals(lasterror, "Last name is required.");
		System.out.println("The error message below the LastName Field is: " + lasterror);
		String mailerror = driver.findElement(By.xpath("//small[normalize-space()='Email address is required.']")).getText();
		Assert.assertEquals(mailerror, "Email address is required.");
		System.out.println("The error message below the Email Field is: " + mailerror);
	    
	}
//	002
	@When("Enter First name")
	public void enter_First_name() {
	    
	}

	@When("Enter Last name")
	public void enter_Last_name() {
	    
	}

	@When("enter Email address")
	public void enter_Email_address() {
	    
	}

	@Then("displays Pop-up message and user click on the close button")
	public void displays_Pop_up_message_and_user_click_on_the_close_button() {
	    
	}


}
