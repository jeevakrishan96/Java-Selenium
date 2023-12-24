package org.setpdefinition;

import Utils.PropertiesReader;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Base.BaseClase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.pojo.pojoSignInpage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static org.testng.Assert.*;

public class GettingPaid extends BaseClase{
	 String SSNValue;
	public Faker faker; 
	public PropertiesReader propertiyReader =null ;
	public  static Logger log;

	public GettingPaid(){
	  log= LogManager.getLogger(GettingPaid.class);
		propertiyReader=new PropertiesReader();
		faker=new Faker();
	}

	@Given("user Launch the {string} Browser and Maximize the window")
	public void userLaunchTheBrowserAndMaximizeTheWindow(String browserName) throws Exception {
		driver=launchBrowser(browserName);
		log.info("Browser successfully launched");
	}

	@When("user launch the Shopdot URL")
	public void user_launch_the_Shopdot_URL() throws AWTException {
		launchurl("https://qa2.shopdotapp.com/login");
	}

	@When("user Login to the ShopDot")
	public void user_Login_to_the_ShopDot() {
		pojoSignInpage g = new pojoSignInpage(driver);
	    sendText(g.getEmail(), propertiyReader.getProperty("GETTING_PAID_USER"));
	    sendText(g.getPassword(), propertiyReader.getProperty("GETTING_PAID_PASSWORD"));
	    clickBtn(g.getLogin());
	}
	
	@When("user clicks on gettingpaid menu")
	public void user_clicks_on_gettingpaid_menu() throws InterruptedException {
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

	@When("Display Gettingpaid menu page")
	public void display_Gettingpaid_menu_page() {
		String text = driver.findElement(By.xpath("//h2[@class='heading bdr-btm-none']")).getText();
		  assertEquals(text, "Getting Paid");
	}

	@When("user selects the option {string} from the Is your business a publicly traded C_Corporation or non-profit?")
	public void user_selects_the_option_from_the_Is_your_business_a_publicly_traded_C_Corporation_or_non_profit(String string) throws InterruptedException {
		System.out.println("//input[@value='"+string+"']");

//		waituntilClickable(driver.findElement(By.xpath("//input[@value='"+string.toLowerCase()+"']")));
		driver.findElement(By.xpath("(//div[@class='radiobox-text'])[2]")).click();


	}

	@When("user selects the option {string} from the Are you an authorized signer?")
	public void user_selects_the_option_from_the_Are_you_an_authorized_signer(String string) throws InterruptedException {

		driver.findElements(By.xpath("//span[text()='"+string+"']")).get(1).click();

	}

	@When("user click on the Start Application button")
	public void user_click_on_the_Start_Application_button() throws InterruptedException{
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		waituntilClickable(driver.findElement(By.xpath("//button[@type='submit']")));
	}
	
	@When("user enter data on the Legal name of business field")
	public void user_enter_data_on_the_Legal_name_of_business_field() {

		driver.findElement(By.xpath("//input[@name='businessName']")).sendKeys(faker.company().name()+"testbusiness");
	}

	@When("user enter data on the Doing business as field")
	public void user_enter_data_on_the_Doing_business_as_field() {
		driver.findElement(By.xpath("//input[@name='businessAs']")).sendKeys(faker.name().lastName()+"Testdoing business");
	}

	@When("user select option in the Business category field")
	public void user_select_option_in_the_Business_category_field() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//div[text()='Select Business Category']/parent::div/following-sibling::div/child::div/child::*[name()='svg']")).click();
		driver.findElement(By.xpath("//div[text()='Single Member LLC']")).click();
	}

	@When("user enter address in the Business website address field")
	public void user_enter_address_in_the_Business_website_address_field() throws AWTException, InterruptedException {
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys(faker.company().url());
	}



	@When("user select {string} sate incorporaion from the select State field")
	public void user_select_sate_incorporaion_from_the_select_State_field(String state) {
		driver.findElement(By.xpath("//div[text()='Select State']/parent::div/following-sibling::div/child::div/child::*[name()='svg']")).click();
	waituntilClickable(driver.findElement(By.xpath("//div[text()='"+state+"']")));
	}
	@And("user select {string} Type from Business category field")
	public void userSelectTaxIDTypeFromTaxIDTypeField(String idType) {
		driver.findElement(By.cssSelector("[value='"+idType+"']"));
	}

	@When("user enter data in the EIN field")
	public void user_enter_data_in_the_EIN_field() throws InterruptedException {
		
	    driver.findElement(By.cssSelector("[name='employerIdentificationNumber']")).sendKeys(generateRandom9DigitNumber());
	}

	@When("user enter email in the Business email address field")
	public void user_enter_email_in_the_Business_email_address_field() {
		 driver.findElement(By.xpath("//input[@name='businessEmail']")).sendKeys(faker.internet().emailAddress());
	}

	@When("user enter phone number in the Business phone number field")
	public void user_enter_phone_number_in_the_Business_phone_number_field() {
		String attribute = driver.findElement(By.xpath("//input[@placeholder='(123) 456-7899']")).getAttribute("placeholder");
		
		boolean empty = attribute.isEmpty();
		assertEquals(false, empty);
		
	    driver.findElement(By.xpath("//input[@placeholder='(123) 456-7899']")).sendKeys("1234567890");
	}

	@When("user enter address in the Address line{int} field")
	public void user_enter_address_in_the_Address_line_field(Integer int1) {
		driver.findElement(By.xpath("//input[@name='addressLine1']")).sendKeys(faker.address().secondaryAddress());
	}

	@When("user enetr address in the Address line{int} field")
	public void user_enetr_address_in_the_Address_line_field(Integer int1) {
		driver.findElement(By.xpath("//input[@name='addressLine2']")).sendKeys("Address for testing lane 2");
	}

	@When("user select country from Country field")
	public void user_select_country_from_Country_field() throws InterruptedException, AWTException {
driver.findElement(By.xpath("//input[@name='countryAddress']/preceding-sibling::div")).click();
driver.findElement(By.xpath("//div[text()='United States']")).click();

	}

	@When("user select {string} sate from the select State field")
	public void user_select_sate_from_the_select_State_field(String state) {
		driver.findElements(By.xpath("//div[text()='Select State']/parent::div/following-sibling::div/child::div/child::*[name()='svg']")).get(0).click();
		driver.findElement(By.xpath("//div[text()='"+state+"']")).click();
	}




	@When("user enter city name in the City Field")
	public void user_enter_city_name_in_the_City_Field() {
		driver.findElement(By.xpath("//input[@placeholder='New York']")).sendKeys(faker.address().cityName());
	}

	@When("user enter zipcode in the ZIP field")
	public void user_enter_zipcode_in_the_ZIP_field() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='10014']")).sendKeys("12121");
	    
	}

	@When("user select state from the State of incorporation field")
	public void user_select_state_from_the_State_of_incorporation_field() throws InterruptedException, AWTException {
		
//	    driver.findElement(By.xpath("//div[@id='react-select-9-placeholder']")).click();
	    
	    try {

			WebElement element = driver.findElement(By.xpath("//input[@id='react-select-5-input']"));
	        // Attempt to click the element
	        element.click();
	        
	    } catch (Exception e) {
	        // Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
	    	WebElement element = driver.findElement(By.xpath("//div[@id='react-select-9-placeholder']"));
	    	JavascriptExecutor executor = (JavascriptExecutor)driver;
	    	

	        executor.executeScript("arguments[0].click();", element);
	    }
	    
	    
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_DOWN);
	    r.keyRelease(KeyEvent.VK_DOWN);
	    
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user select date in the Date of incorporation field")
	public void user_select_date_in_the_Date_of_incorporation_field() throws InterruptedException {
		Timewait();
	    driver.findElement(By.xpath("//input[@placeholder='MM-DD-YYYY']")).click();
	    
	    driver.findElement(By.xpath("//div[@aria-label='Choose Sunday, November 26th, 2023']")).click();
	}

	@When("user enter data in the Estimated average sales volume on ShopDot field")
	public void user_enter_data_in_the_Estimated_average_sales_volume_on_ShopDot_field() throws InterruptedException {
		
	    driver.findElement(By.xpath("//input[@name='averageSales']")).sendKeys("10000");
	}

	@When("user enter data in the Estimated average wholesale price on ShopDot field")
	public void user_enter_data_in_the_Estimated_average_wholesale_price_on_ShopDot_field() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='averageSalePrice']")).sendKeys("500");
	}

	@When("user select time in the Average delivery time field")
	public void user_select_time_in_the_Average_delivery_time_field() throws InterruptedException, AWTException {
		
		driver.findElement(By.xpath("//input[@id='react-select-6-input']")).click();
		

	    
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user select code from the Merchant category code field")
	public void user_select_code_from_the_Merchant_category_code_field() throws InterruptedException, AWTException {
//		driver.findElement(By.xpath("//div[19]//div[1]//div[1]//div[2]//div[1]")).click();
	    
		try {

			WebElement element = driver.findElement(By.xpath("(//input[@type='text'])[17]"));
            // Attempt to click the element
            element.click();
            
        } catch (Exception e) {
            // Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
        	WebElement element = driver.findElement(By.xpath("(//input[@type='text'])[17]"));
        	JavascriptExecutor executor = (JavascriptExecutor)driver;
        	
//            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }
		Thread.sleep(2000);
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user enter data in the Product description field")
	public void user_enter_data_in_the_Product_description_field() {
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Testing the Products");
	}

	@When("user click on the save button")
	public void user_click_on_the_save_button() throws InterruptedException {
		
	    driver.findElement(By.xpath("//button[normalize-space()='Save and Next']")).click();
	}

	@When("user enter first name in the Legal name of business representative field")
	public void user_enter_first_name_in_the_Legal_name_of_business_representative_field() {
		driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Test firstname");
	}

	@When("user enter last name in the Legal name of business representative field")
	public void user_enter_last_name_in_the_Legal_name_of_business_representative_field() {
		 driver.findElement(By.xpath("//input[@placeholder='Last name']")).sendKeys("Test Lastname");
	}

	@When("user enter phone number in the Phone number field")
	public void user_enter_phone_numer_in_the_Phone_number_field() {
		driver.findElement(By.xpath("//input[@placeholder='(123) 456-7899']")).sendKeys("1234567890");
	}

	@When("user enter SSN number in the Social Security Number field")
	public void user_enter_SSN_numer_in_the_Social_Security_Number_field() {
		driver.findElement(By.xpath("//input[@placeholder='123-44-5678']")).sendKeys(generateRandom9DigitNumber());

	}

	@When("user select Date of birth")
	public void user_select_Date_of_birth() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='MM-DD-YYYY']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[@aria-label='Choose Tuesday, November 29th, 2005']")).click();
	}

	@When("user enter Email address")
	public void user_enter_Email_address() throws InterruptedException {
		
	    driver.findElement(By.xpath("//input[@placeholder='yourname@email.com']")).sendKeys(faker.internet().emailAddress());
	}

	@When("user enter Home Address")
	public void user_eneter_Home_Address() {
		driver.findElement(By.xpath("//input[@name='representativeDetails.0.addressLine1']")).sendKeys("Home Address line 1");
	}

	@When("user select Country")
	public void user_select_Country() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//div[@class='form-input']//div[@class='select__input-container css-19bb58m']")).click();
	    
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user select State")
	public void user_select_State() throws AWTException, InterruptedException {
		driver.findElement(By.xpath("//div[@class='form-input mb-2']//div[@class='select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer']")).click();
	    
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user enter City name")
	public void user_enter_City_name() {
		driver.findElement(By.xpath("//input[@placeholder='New York']")).sendKeys("NY");
	}

	@When("user enter ZIP")
	public void user_enter_ZIP() {
		driver.findElement(By.xpath("//input[@placeholder='10014']")).sendKeys("12121");
	}

	@When("user selects Secondary identification")
	public void user_selects_Secondary_identification() throws AWTException {
//		Secondary identification
		
	    driver.findElement(By.xpath("//div[@class='basic-single css-11qaloi-container']//div[@class='select__input-container css-19bb58m']")).click();
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	    
//	    State of issuance
	    driver.findElement(By.xpath("//div[@class='form-input mb-2 state_issuance mt-4']//div[@class='select__input-container css-19bb58m']")).click();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	    driver.findElement(By.xpath("//input[@placeholder='ID Number']")).sendKeys("12345678910");
	}

	@When("click on the Save and Next button")
	public void click_on_the_Save_and_Next_button() {
		driver.findElement(By.xpath("//button[normalize-space()='Save and Next']")).click();
		
	}

	@When("user enter name on the Name of the bank account holder field")
	public void user_enter_name_on_the_Name_of_the_bank_account_holder_field() {
		driver.findElement(By.xpath("//input[@name='accountHolderName']")).sendKeys("Tester");
	}

	@When("user select Bank account type")
	public void user_select_Bank_account_type() throws IOException {
	    screenShot("SB");
	}

	@When("user enter Account number")
	public void user_enter_Account_number() {
		driver.findElement(By.xpath("//input[@name='accountNumber']")).sendKeys("1234567890");
	}

	@When("user enter Routing number")
	public void user_enter_Routing_number() {
		driver.findElement(By.xpath("//input[@name='routingNumber']")).sendKeys(propertiyReader.getProperty("Routingnumber"));
	}

	@When("navigate to the summary page")
	public void navigate_to_the_summary_page() {
		 String summarypage = driver.findElement(By.xpath("//h3[normalize-space()='Summary']")).getText();
		    assertEquals(summarypage, "Summary");
	}

	@When("user click on the checkbox")
	public void user_click_on_the_checkbox() {
		 driver.findElement(By.xpath("//label[@for='check-a']//div[@class='checkbox-text']")).click();
		    driver.findElement(By.xpath("//label[@for='check-b']//div[@class='checkbox-text']")).click();
	}

	@When("user click on the submit button")
	public void user_click_on_the_submit_button() throws InterruptedException {

		try {

			WebElement element = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
            // Attempt to click the element
            element.click();
            
        } catch (Exception e) {
            // Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
        	WebElement element = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        	JavascriptExecutor executor = (JavascriptExecutor)driver;
        	

            executor.executeScript("arguments[0].click();", element);
        }
		
	}

	@Then("pop-up will display and user click on the Close button")
	public void pop_up_will_display_and_user_click_on_the_Close_button() throws InterruptedException, IOException {
		
//		driver.findElement(By.className("popup-close button cancel")).click();
		
		try {	
		if (driver.findElements(By.xpath("//div[@role='alert']")).size()!=0) {
			screenShot("pop");
			assertFalse(true);		}
		
		else {
			assertTrue(true);
		}
		} catch (Exception e) {
			System.err.println(e);
		}
//		waitforElementVisiblity(driver.findElement(By.className("popup-close button cancel"))).click();
	}

   
//	002


	@When("user enter data in the SSN field")
	public void user_enter_data_in_the_SSN_field() {
	    driver.findElements(By.xpath("//input[@type='tel']")).get(0).sendKeys(generateRandom9DigitNumber());

	}

	@When("SSN number should have filled as like in the Business Details page")
	public void ssn_number_should_have_filled_as_like_in_the_Business_Details_page() {
	    
	}

// GP003 Sole Proprietor
	@When("user select an option Sole Proprietor in the Business category field")
	public void user_select_an_option_Sole_Proprietor_in_the_Business_category_field() throws InterruptedException, AWTException {
	    
		driver.findElement(By.xpath("//div[@class='form-input mb-4 business_category']//div[@class='select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer']//*[name()='svg']")).click();
		Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

//	@GP005
	@When("user select an option LLC in the Business category field")
	public void user_select_an_option_LLC_in_the_Business_category_field() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//div[@class='form-input mb-4 business_category']//div[@class='select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer']//*[name()='svg']")).click();
		
		Robot r = new Robot();
		for (int i = 0; i < 2; i++) {
			
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}


	@When("user enter website address in the Business website address field")
	public void user_enter_website_address_in_the_Business_website_address_field() {
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("tesstling.com");
	}
	@When("user select country from Country field.")
	public void user_select_country_from_Country_field1() throws AWTException, InterruptedException {
	    driver.findElement(By.xpath("//input[@id='react-select-3-input']")).click();
	    Thread.sleep(1500);
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user select state from the State of incorporation field.")
	public void user_select_state_from_the_State_of_incorporation_field1() throws InterruptedException, AWTException {
	    driver.findElement(By.xpath("//div[@id='react-select-9-placeholder']")).click();
	    Thread.sleep(1500);
	    Robot r = new Robot();
	    Thread.sleep(1000);
	    r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user select code from the Merchant category code field.")
	public void user_select_code_from_the_Merchant_category_code_field1() throws AWTException, InterruptedException {
		driver.findElement(By.xpath("//input[@id='react-select-7-input']")).click();
		
		Robot r = new Robot();
	    Thread.sleep(1000);
	    r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
//BR
	@When("user select the Country in Business category")
	public void user_select_the_Country_in_Business_category() throws InterruptedException, AWTException {
	   driver.findElement(By.xpath("//input[@id='react-select-9-input']")).click();
	   Robot r = new Robot();
	    Thread.sleep(1000);
	    r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user select the State in Business category")
	public void user_select_the_State_in_Business_category() throws AWTException, InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='react-select-10-input']")).click();
		Robot r = new Robot();
		Thread.sleep(1000);
	    r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user enter the SSN number")
	public void user_enter_the_SSN_number() {
	    driver.findElement(By.xpath("//input[@placeholder='123-44-5678']")).sendKeys(propertiyReader.getProperty("SSN"));
	}

	@When("selects the date of birth")
	public void selects_the_date_of_birth() throws InterruptedException {

		driver.findElement(By.xpath("//input[@placeholder='MM-DD-YYYY']")).click();
		Thread.sleep(1500);
	    driver.findElement(By.cssSelector("div[aria-label='Choose Thursday, December 1st, 2005']")).click();
	}

	@When("user Email address")
	public void user_Email_address() {
		driver.findElement(By.xpath("//input[@placeholder='yourname@email.com']")).sendKeys("ttemail@test.com");
	}

	@When("user enter Home Address line{int}")
	public void user_enter_Home_Address_line(Integer int1) {
		 driver.findElement(By.xpath("//input[@name='representativeDetails.0.addressLine1']")).sendKeys("Home Address line 1");
	}

	@When("user enter the Home Address line{int}")
	public void user_enter_the_Home_Address_line(Integer int1) {
	    driver.findElement(By.xpath("//input[@name='representativeDetails.0.addressLine2']")).sendKeys("Home Address line2");
	}

	@When("user select the Country")
	public void user_select_the_Country() throws InterruptedException, AWTException {
		
		driver.findElement(By.xpath("(//input[@type='text'])[8]")).click();
//		try {
//
//			WebElement element = driver.findElement(By.xpath("(//input[@type='text'])[9]"));
//            // Attempt to click the element
//            element.click();
//            
//        } catch (Exception e) {
//            // Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
//        	WebElement element = driver.findElement(By.xpath("(//input[@type='text'])[9]"));
//        	JavascriptExecutor executor = (JavascriptExecutor)driver;
//        	
//
//            executor.executeScript("arguments[0].click();", element);
//        }
		Thread.sleep(1500);
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}


	@When("user select the State")
	public void user_select_the_State() throws InterruptedException, AWTException {
		
		driver.findElement(By.xpath("(//input[@type='text'])[9]")).click();
	    Thread.sleep(2000);
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user enter the City")
	public void user_enter_the_City() {
		driver.findElement(By.xpath("//input[@placeholder='New York']")).sendKeys("NY");
	}

	@When("user enter the ZIP")
	public void user_enter_the_ZIP() {
		driver.findElement(By.xpath("//input[@placeholder='10014']")).sendKeys("12121");
	}

	@When("user selects the Identification type")
	public void user_selects_the_Identification_type() throws AWTException {
		driver.findElement(By.xpath("//div[@class='basic-single css-11qaloi-container']//div[@class='select__input-container css-19bb58m']")).click();
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	    	    
	}
	
	@When("user select country from Country of issuance")
	public void user_select_country_from_Country_of_issuance() throws AWTException {
//	    State of issuance
	    driver.findElement(By.xpath("//div[@class='form-input mb-2 state_issuance mt-4']//div[@class='select__input-container css-19bb58m']")).click();
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user enter ID number")
	public void user_enter_ID_number() {
		driver.findElement(By.xpath("//input[@placeholder='ID Number']")).sendKeys("12345678910");
	}

	@When("user enter Percentage ownership")
	public void user_enter_Percentage_ownership() {
	    driver.findElement(By.xpath("//input[@type='number']")).sendKeys("50");
	}

	@When("user click on the Save and next button")
	public void user_click_on_the_Save_and_next_button() {
		driver.findElement(By.xpath("//button[normalize-space()='Save and Next']")).click();
		
	}
//	@GP006
	@When("user select an option LLP in the Business category field")
	public void user_select_an_option_LLP_in_the_Business_category_field() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//div[@class='form-input mb-4 business_category']//div[@class='select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer']//*[name()='svg']")).click();
		Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
	}
	@When("user select the country from Country field")
	public void user_select_the_country_from_Country_field() throws AWTException, InterruptedException {
	   driver.findElement(By.xpath("//input[@id='react-select-3-input']")).click();
	   Thread.sleep(1000);
	   Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}


	@When("user select the state from the State of incorporation field")
	public void user_select_the_state_from_the_State_of_incorporation_field() throws AWTException, InterruptedException {
		driver.findElement(By.xpath("//input[@id='react-select-5-input']")).click();
		Thread.sleep(1000);
		Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user select time in Average delivery time field")
	public void user_select_time_in_Average_delivery_time_field() throws AWTException, InterruptedException {
		driver.findElement(By.xpath("//input[@id='react-select-6-input']")).click();
		Thread.sleep(1000);
		Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user select the code from  Merchant category code field")
	public void user_select_the_code_from_Merchant_category_code_field() throws AWTException {
		driver.findElement(By.xpath("//input[@id='react-select-7-input']")).click();
		Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);    
	}
//	BR
	@When("user selects the Country")
	public void user_selects_the_Country() throws AWTException {
	    driver.findElement(By.xpath("//input[@id='react-select-9-input']")).click();
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user selects the State")
	public void user_selects_the_State() throws AWTException, InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='react-select-10-input']")).click();
		Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	
//	@GP007
	@When("user select an option Partnership in the Business category field")
	public void user_select_an_option_Partnership_in_the_Business_category_field() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//div[@class='form-input mb-4 business_category']//div[@class='select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer']//*[name()='svg']")).click();
		Thread.sleep(1000);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	@When("user selects country from Country field")
	public void user_selects_country_from_Country_field() throws AWTException {
		driver.findElement(By.xpath("//input[@id='react-select-3-input']")).click();
		Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user selects state from the select State field")
	public void user_selects_state_from_the_select_State_field() throws AWTException, InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='react-select-4-input']")).click();
		Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user selects state from the State of incorporation field")
	public void user_selects_state_from_the_State_of_incorporation_field() throws AWTException {
		driver.findElement(By.xpath("//input[@id='react-select-5-input']")).click();
		Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user selects time in the Average delivery time field")
	public void user_selects_time_in_the_Average_delivery_time_field() throws AWTException {
		driver.findElement(By.xpath("//input[@id='react-select-6-input']")).click();
		Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user selects code from the Merchant category code field")
	public void user_selects_code_from_the_Merchant_category_code_field() throws AWTException {
	    driver.findElement(By.xpath("//input[@id='react-select-7-input']")).click();
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}
	
//	@GP008
	@When("user select an Option S_CORP in the Business category field")
	public void user_select_an_Option_S_CORP_in_the_Business_category_field() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//div[@class='form-input mb-4 business_category']//div[@class='select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer']//*[name()='svg']")).click();
		Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
//	@GP009
	@When("user select an Option C_CORP - Not Publicly Traded in the Business category field")
	public void user_select_an_Option_C_CORP_Not_Publicly_Traded_in_the_Business_category_field() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//div[@class='form-input mb-4 business_category']//div[@class='select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer']//*[name()='svg']")).click();
		Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	@And("user select Tax ID Type as {string}")
	public void userSelectTaxIDTypeAs(String taxID) {
		scrollToTheElement(driver.findElement(By.xpath("//label[contains(text(),'Tax ID Type')]/following-sibling::div")));
		driver.findElement(By.xpath("//label[contains(text(),'Tax ID Type')]/following-sibling::div")).click();
		driver.findElement(By.xpath("//div[text()='"+taxID+"']")).click();

	}



//	@Then("pop-up will display and user click on the Close button")
//	public void pop_up_will_display_and_user_click_on_the_Close_button() throws InterruptedException {
//	    Thread.sleep(4000);
//	    String text = driver.findElement(By.xpath("//p[@class='mb-4']")).getText();
//	    System.out.println(text);
//	    Thread.sleep(5000);
//	    driver.findElement(By.xpath("//button[@class='popup-close button cancel']")).click();
	}
	
