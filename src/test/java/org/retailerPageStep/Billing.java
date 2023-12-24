package org.retailerPageStep;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import Utils.PropertiesReader;
import org.Base.BaseClase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Billing extends BaseClase{
	public PropertiesReader propertiyReader =null ;
	public Faker faker;
	public  static Logger log;
	public Billing(){
		log= LogManager.getLogger(Billing.class);
		propertiyReader=new PropertiesReader();
		faker=new Faker();
	}
	
	@Given("retailer Launch the Browser and Maximize the Window")
	public void retailer_Launch_the_Browser_and_Maximize_the_Window() throws Exception {
	    launchBrowser("chrome");
	}

	@When("retailer hit the Shopdot URL")
	public void retailer_hit_the_Shopdot_URL() {
	    launchurl("https://qa2.shopdotapp.com/login");
	}

	@When("retailer Login to the ShopDot Application")
	public void retailer_Login_to_the_ShopDot_Application() {
		driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys("shopdottesting005@yopmail.com");
		   driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Welcome6@123");
		   driver.findElement(By.xpath("//div[@class='form-input mt-5']")).click();

		  
	}
//01
	
	@When("click on the billing menu")
	public void click_on_the_billing_menu() throws InterruptedException {
		faker=new Faker();
//		if (driver.getCurrentUrl().equalsIgnoreCase("https://qa2.shopdotapp.com/retailer/dashboard")) {
//			mouseHoverToElement(driver.findElement(By.xpath("(//span[@class='icon'])[2]")));
//			waituntilClickable(driver.findElement(By.xpath("//a[normalize-space()='Settings']")));
//
//		}
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//a[@data-link='Billing']")).click();
	}

	@When("retailer click on the Add new credit card")
	public void retailer_click_on_the_Add_new_credit_card() {

		driver.findElement(By.xpath("//button[contains(@class,'button-new w-260 button-white-borderd')]")).click();
	}

	@When("displays Add new credit card screen")
	public void displays_Add_new_credit_card_screen() {
		String text = driver.findElement(By.xpath("//h1[normalize-space()='Add New Credit Card']")).getText();
		assertEquals(text, "Add New Credit Card");
		System.out.println(text);
	}

	@When("retailer enter firstname")
	public void retailer_enter_firstname() {
		driver.findElement(By.xpath("//input[contains(@placeholder,'Enter the first name of user')]")).sendKeys(faker.name().firstName()+"Testings");
	}

	@When("enter lastname")
	public void enter_lastname() {
		driver.findElement(By.xpath("//input[@placeholder='Enter the last name of user']")).sendKeys(faker.name().lastName()+"tester");
	}

	@When("enter Phone number")
	public void enter_Phone_number() {
		driver.findElement(By.xpath("//input[@placeholder='XXX-XXX-XXXX']")).sendKeys(faker.phoneNumber().phoneNumber());
	}

	@When("enter Card number")
	public void enter_Card_number() {
		driver.findElement(By.xpath("//input[@placeholder='Enter your credit card number']")).sendKeys("4111-1111-1111-1111");
	}

	@When("enter Expiration date")
	public void enter_Expiration_date() {
		driver.findElement(By.xpath("//input[@placeholder='MM / YYYY']")).sendKeys("122029");
	}

	@When("enter CVV number")
	public void enter_CVV_number() {
		driver.findElement(By.xpath("//input[@name='cvv']")).sendKeys("122");
	}

	@When("enter Billing address")
	public void enter_Billing_address() {
		driver.findElement(By.xpath("//input[@placeholder='Suite/Building number, floor number, Street number etc...']")).sendKeys("testing address");
	}

	@When("retailer selects Country")
	public void retailer_selects_Country() throws InterruptedException, AWTException, IOException {
//		waitforElementVisiblity(driver.findElement(By.xpath("//input[@id='react-select-2-input']"))).click();
		
		driver.findElement(By.xpath("(//input[@type='text'])[8]")).click();
		Thread.sleep(5000);
		screenShot("bill");
		
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("retailer selects the State")
	public void retailer_selects_the_State() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("(//input[@type='text'])[9]")).click();
		
		Thread.sleep(1000);
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("retailer enter City")
	public void retailer_enter_City() {
		driver.findElement(By.xpath("//input[@placeholder='San Jose']")).sendKeys("San jose");
	}

	@When("retailer enter ZIP")
	public void retailer_enter_ZIP() {
		driver.findElement(By.xpath("//input[@placeholder='12345']")).sendKeys("12321");
	}

	@When("click on the save button")
	public void click_on_the_save_button() {
		driver.findElement(By.xpath("//div[@class='form-input form-submit']")).click();
	}

	@Then("redirect to the main screen")
	public void redirect_to_the_main_screen() {
		String text1 = driver.findElement(By.xpath("//h1[normalize-space()='Saved Payment Methods']")).getText();
		assertEquals(text1, "Saved Payment Methods");
		log.info(text1);
		
		String text2 = driver.findElement(By.xpath("//h1[normalize-space()='Congratulations!']")).getText();
		assertEquals(text2, "Congratulations!");
		log.info(text2);
		
		driver.findElement(By.xpath("//div[@class='popup-close close_icon']")).click();
	}

}
