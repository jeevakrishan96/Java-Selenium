package org.setpdefinition.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;

import com.github.javafaker.Faker;
import org.Base.BaseClase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.pojo.pojoSignInpage;

import Utils.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.setpdefinition.GettingPaid;

public class Plans extends BaseClase{
//	PropertiesReader p=null;
public Faker faker;
	public PropertiesReader propertiyReader =null ;
	public  static Logger log;

	public Plans(){
		log= LogManager.getLogger(Plans.class);
		propertiyReader=new PropertiesReader();
		faker=new Faker();
	}
	@Given("user lauch the browser and Maximize the Window")
	public void user_lauch_the_browser_and_Maximize_the_Window() throws Exception {
	    driver = launchBrowser("chrome");
	}

	@When("user to hit the ShopDot URL")
	public void user_to_hit_the_ShopDot_URL() {
	    launchurl("https://qa2.shopdotapp.com/login");
	}

	@When("user login to the ShopDot Application")
	public void user_login_to_the_ShopDot_Application() throws InterruptedException {
//		Thread.sleep(1000);
//		 p = new PropertiesReader();
		
	    pojoSignInpage g = new pojoSignInpage(driver);
	    sendText(g.getEmail(), propertiyReader.getProperty("PLANSLOGIN"));
	    sendText(g.getPassword(), "Welcome6@123");
	    clickBtn(g.getLogin());
	    
	    
//	    try {
//
//			WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Settings']"));
//           // Attempt to click the element
//           element.click();
//           
//       } catch (Exception e) {
//           // Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
//       	WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Settings']"));
//       	JavascriptExecutor executor = (JavascriptExecutor)driver;
//       	
////           JavascriptExecutor executor = (JavascriptExecutor) driver;
//           executor.executeScript("arguments[0].click();", element);
//       }
	}
	
	@When("user click on the Plans Menu button")
	public void user_click_on_the_Plans_Menu_button() throws InterruptedException {
		
	    waituntilClickable(driver.findElement(By.xpath("//a[normalize-space()='Plans']"))).click();
	    
	   
	}

//	@When("user clicks on the Plans Menu button")
//	public void user_clicks_on_the_Plans_Menu_button() throws InterruptedException {
//		Thread.sleep(1000);
//	    driver.findElement(By.xpath("//a[normalize-space()='Plans']")).click();
//	    
//	    Thread.sleep(1000);
//	}

	@When("Displays the Subscription Plans Screen")
	public void displays_the_Subscription_Plans_Screen() throws InterruptedException {
	    String plan = driver.findElement(By.xpath("//h2[normalize-space()='Subscription Plans']")).getText();
	    Assert.assertEquals(plan, "Subscription Plans");
	    System.out.println("Page landed on the Screen: " + plan);
	    Thread.sleep(2000);
	}

	@When("user click on the Select Plan button on the Starter")
	public void user_click_on_the_Select_Plan_button_on_the_Starter() {
		
	    waituntilClickable(driver.findElement(By.xpath("//tbody/tr/td[2]/span[1]/button[1]"))).click();
	}

	@Then("user should see the popup message on the screen")
	public void user_should_see_the_popup_message_on_the_screen() throws IOException {
	    screenShot("im");
	}

	@When("user click on the confirm button")
	public void user_click_on_the_confirm_button() {
	    driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
	}
	@Then("display Pop-up message and user clicks side arrow button")
	public void display_Pop_up_message_and_user_clicks_side_arrow_button() throws InterruptedException {

		String pop = driver.findElement(By.xpath("//div[@class='h1 text-dark']")).getText().trim();
		log.info("The received message is: " + pop);
		Assert.assertTrue(pop.contains("Nice work!") );

		for (int i = 0; i < 3; i++) {
			Thread.sleep(3000);
			log.info("it is clicked" + i);
			driver.findElement(By.xpath("//button[@class='slick-arrow slick-next']")).click();
		}

	}

	@Then("user click on the lets go button")
	public void user_click_on_the_lets_go_button() throws InterruptedException {
		String activate = driver.findElement(By.xpath("//div[contains(text(),'Activate your products')]")).getText().trim();
	    Assert.assertTrue(activate.contains("Activate your products"));
	    log.info(activate);
		Thread.sleep(2500);
		driver.findElement(By.xpath("//button[@class='popup-close button button-dark']")).click();
	}

	@Then("user will be taken to the next step in onboarding \\(Products Page)")
	public void user_will_be_taken_to_the_next_step_in_onboarding_Products_Page() {
	    String pro = driver.findElement(By.xpath("//h1[normalize-space()='Products']")).getText();
		log.info("The Displayed Page is : " +pro);
	    Assert.assertEquals(pro, "Products");

	}
//	Growth
	
	@When("user click on the Select Plan button on the Growth a confirmation window appears with a field to enter credit card information")
	public void user_click_on_the_Select_Plan_button_on_the_Growth_a_confirmation_window_appears_with_a_field_to_enter_credit_card_information() {
		driver.findElement(By.xpath("//tbody/tr/td[3]/span[1]/button[1]")).click();
	}
	
	@When("user enter First Name")
	public void user_enter_First_Name() {
	    driver.findElement(By.xpath("//input[@placeholder='Enter the first name of user']")).sendKeys("Tester1");
	}

	@When("user enter Last Name")
	public void user_enter_Last_Name() {
	    driver.findElement(By.xpath("//input[@placeholder='Enter the last name of user']")).sendKeys("Tester2");
	}

	@When("user enter Phone number")
	public void user_enter_Phone_number() {
	    driver.findElement(By.xpath("//input[@placeholder='XXX-XXX-XXXX']")).sendKeys("1212123654");
	}

	@When("user enter Card number")
	public void user_enter_Card_number() {
	    driver.findElement(By.xpath("//input[@name='cardNumber']")).sendKeys("4111111111111111");
	}

	@When("user enter Card Expiry date")
	public void user_enter_Card_Expiry_date() {
	    driver.findElement(By.xpath("//input[@placeholder='MM / YYYY']")).sendKeys("062024");
	}

	@When("user enter Card CVV number")
	public void user_enter_Card_CVV_number() {
	    driver.findElement(By.xpath("//input[@id='cvv']")).sendKeys("123");
	}

	@When("user enter Billing address")
	public void user_enter_Billing_address() {
	    driver.findElement(By.xpath("//input[@name='billingAddress']")).sendKeys("Billing address one");
	    driver.findElement(By.xpath("//input[@name='billingAddressTwo']")).sendKeys("Billing address two");
	}
	@When("user select the country")
	public void user_select_the_country() throws AWTException {
	    driver.findElement(By.xpath("//div[@class='form-input']//div[@class='select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer']")).click();
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user select the state")
	public void user_select_the_state() throws InterruptedException, AWTException {

	    driver.findElement(By.xpath("//div[@class='form-input mb-2']//div[@class='select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer']")).click();
	    Thread.sleep(2000);
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_DOWN);
	    r.keyRelease(KeyEvent.VK_DOWN);
	    
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user enter the city")
	public void user_enter_the_city() {
	    driver.findElement(By.xpath("//input[contains(@placeholder,'New York')]")).sendKeys("NY");
	}

	@When("user the ZIP")
	public void user_the_ZIP() {

		driver.findElement(By.xpath("//input[@placeholder='12345']")).sendKeys("12345");
	}

	@When("user click on the Submit button")
	public void user_click_on_the_Submit_button() throws InterruptedException {
	    driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();


//	    driver.switchTo().frame("intercom-frame");
//	    for (int i = 1; i <= 3; i++) {
//			Thread.sleep(3000);
//			log.info("it is clicked: " + i);
//	    	driver.findElement(By.xpath("//button[@class='slick-arrow slick-next']")).click();
//		}
//	    driver.findElement(By.xpath("//button[@class='popup-close button button-dark']")).click();

	}

// Scale Plan
	@When("user click on the Select Plan button on the Scale and a confirmation window appears with a field to enter credit card information")
	public void user_click_on_the_Select_Plan_button_on_the_Scale_and_a_confirmation_window_appears_with_a_field_to_enter_credit_card_information() {
	    driver.findElement(By.xpath("//tbody/tr/td[4]/span[1]/button[1]")).click();
	}

}
