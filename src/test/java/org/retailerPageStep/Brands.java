package org.retailerPageStep;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

import Utils.PropertiesReader;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import org.Base.BaseClase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.setpdefinition.Pages.ConnectedRetailer;
import org.testng.Assert;

import java.util.List;

public class Brands extends BaseClase{
	public List<WebElement> afterSearchBrandList;
	public PropertiesReader propertiyReader =null ;
	public Faker faker;
	public  static Logger log;
	public Brands(){
		log= LogManager.getLogger(Brands.class);
		propertiyReader=new PropertiesReader();
		faker=new Faker();
	}
	
	@Given("user launch the browser and Maximize window")
	public void user_launch_the_browser_and_Maximize_window() throws Exception {
		driver=  launchBrowser("chrome");
	}

	@When("to hit the Shopdot Url")
	public void to_hit_the_Shopdot_Url() {
		launchurl("https://qa2.shopdotapp.com/login");
	}

	@When("user login to the Shopdot Application")
	public void user_login_to_the_Shopdot_Application() {
		driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(propertiyReader.getProperty("RetailerLogin"));
		   driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Welcome6@123");
		   driver.findElement(By.xpath("//div[@class='form-input mt-5']")).click();
	}

	@When("click on the Brands menu")
	public void click_on_the_Brands_menu() {
	    driver.findElement(By.xpath("//a[normalize-space()='Brands']")).click();
	}
//	001
	@When("user select a Brands and click on the connect button")
	public void user_select_a_Brands_and_click_on_the_connect_button() throws InterruptedException {
		Thread.sleep(5000);
	    String status = driver.findElement(By.xpath("(//span[@class='status-pill pill_not_connected false false false'])[1]")).getText();
	    assertEquals(status, "Not Connected");
	    System.out.println("The Brand status is: " + status);
	    
	    waituntilClickable(driver.findElement(By.xpath("(//button[@class='button button-dark connect-brand'])[1]"))).click();
	}

	@When("displays the sucessful message {string}")
	public void displays_the_sucessful_message(String string) {
	    String sucessfultext = driver.findElement(By.xpath("//h2[normalize-space()='Connect Request Sent Successfully!']")).getText();
	    assertEquals(sucessfultext, "Connect Request Sent Successfully!");
		log.info(sucessfultext);

	}

	@When("click on the close button in the popup")
	public void click_on_the_close_button_in_the_popup() {
	    driver.findElement(By.xpath("//button[normalize-space()='Close']")).click();
	}

	@Then("Status changes to {string}")
	public void status_changes_to(String string) throws InterruptedException {
	    Thread.sleep(4000);
	    String status = driver.findElement(By.xpath("//tbody/tr[2]/td[4]/div[1]/span[1]")).getText();
	    assertEquals(status, "Pending");
	    System.out.println("Now The Brand status is: " + status);
	}
	
//002
	@When("the user is on the Brand Listing page")
	public void the_user_is_on_the_Brand_Listing_page() throws InterruptedException {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentUrl);
		String br = driver.findElement(By.xpath("//h1[normalize-space()='Brands']")).getText();
		assertEquals(br,"Brands");
		System.out.println("The user is on the " + br);
		
		Thread.sleep(4000);
	}
	@When("the user enters keyword in the search bar")
	public void the_user_enters_keyword_in_the_search_bar() {
		List<WebElement> BrandList = driver.findElements(By.xpath("//div[@class='store']"));
		String type = BrandList.get(generateRandomNumber(0, BrandList.size() - 1)).getText().substring(0, 3);
		log.info("Entering the Keyword Randomly in the Connected Retailer : " + type );
		typeText(type,driver.findElement(By.xpath("//input[@type='text']")));
	}
	@Then("the Application displays only those brands in the filter that match keyword")
	public void the_Application_displays_only_those_brands_in_the_filter_that_match_keyword() throws InterruptedException {
		Thread.sleep(3000);
		afterSearchBrandList = driver.findElements(By.xpath("//div[@class='store']"));
		String brandName = afterSearchBrandList.get(generateRandomNumber(0, afterSearchBrandList.size()-1)).getText();
		log.info("The Retailer displayed the char that match the search word : " + brandName);

	}
//003
	@When("the user enters nonexistent_keyword in the search bar")
	public void the_user_enters_nonexistent_keyword_in_the_search_bar() {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(faker.name().firstName());
		WebElement afterSearchList = driver.findElement(By.xpath("//input[@type='text']"));
		String BrandName = afterSearchList.getText();
		log.info("The Retailer displayed the char that did not match the search word : " + BrandName);
	}

	@Then("the message {string}is displayed in the table")
	public void theMessageIsDisplayedInTheTable(String text) {
	    assertEquals(text,driver.findElement(By.xpath("//p[normalize-space()='There are no brands that meet your criteria.']")).getText().trim(),text);
		log.info("The waring message is: " + driver.findElement(By.xpath("//p[normalize-space()='There are no brands that meet your criteria.']")).getText());
	}

	@Then("the Application displays the result count as {int}")
	public void the_Application_displays_the_result_count_as(Integer int1) {
		String count = driver.findElement(By.xpath("//div[@class='number']")).getText();
		log.info(count);

	}

}
