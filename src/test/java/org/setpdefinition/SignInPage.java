package org.setpdefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.Base.BaseClase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pojo.pojoSignInpage;

import Utils.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInPage extends BaseClase{
	public PropertiesReader propertiyReader = null;
	pojoSignInpage p;

	@When("To launch the Shopdot URL")
	public void To_launch_the_Shopdot_URL() throws InterruptedException {
	    launchurl("https://qa2.shopdotapp.com/login");
	    Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();
		propertiyReader=new PropertiesReader();
	}

	@When("User has to pass the data {string} in the Email field")
	public void user_has_to_pass_the_data_in_the_Email_field(String ema) throws InterruptedException {
		
		WebElement tx = driver.findElement(By.xpath("//input[@placeholder='Email address']"));
		String text = tx.getText();
		System.out.println(text);
		
		Thread.sleep(2000);
		
	    p =new pojoSignInpage(driver);
	    
	    sendText(p.getEmail(), ema);
	    
	}

	@When("User has to Pass the data {string} in the Password field")
	public void user_has_to_Pass_the_data_in_the_Password_field(String pass) {
		 p =new pojoSignInpage(driver);
		 sendText(p.getPassword(), pass);
	}

	@When("User has to click on the SignIn button")
	public void user_has_to_click_on_the_SignIn_button() throws InterruptedException, IOException {
		 p =new pojoSignInpage(driver);
		 clickBtn(p.getLogin());
		 Thread.sleep(20000);
		 screenShot("err");
	}

	@Then("close the browser")
	public void close_the_browser() {
	    closeEntireBrowser();
	}


//	@Given("To launch the chrome browser and maximise window")
//	public void to_launch_the_chrome_browser_and_maximise_window() throws Exception {
//	    launchBrowser("chrome");
//	}

//	@When("To launch the Shopdot URL")
//	public void to_launch_the_Shopdot_URL() {
//	   launchurl("https://qa2.shopdotapp.com/login");
//	}
	
	@When("check wheather SignIn button is enable or Disable")
	public void check_wheather_SignIn_button_is_enable_or_Disable() {
		
		boolean enabled = driver.findElement(By.xpath("//button[normalize-space()='Log in']")).isEnabled();
		System.out.println(enabled);
	}

	@Then("To close the Browser")
	public void to_close_the_Browser() {
	    closeEntireBrowser();
	}
	
	@When("User enter the valid EmailId in the emailid field")
	public void user_enter_the_valid_EmailId_in_the_emailid_field() {
	    driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(propertiyReader.getProperty("signemail"));
	}

	@When("User enter the Valid Password in the Password field")
	public void user_enter_the_Valid_Password_in_the_Password_field() {
	    driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Welcome6@123");
	}

	@When("User clicks on the SignIn button")
	public void user_clicks_on_the_SignIn_button() {
	    driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	}

	@Then("User should navigate to Dasboard Page")
	public void user_should_navigate_to_Dasboard_Page() {

	}
}