package org.setpdefinition.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import Utils.PropertiesReader;
import com.github.javafaker.Faker;
import org.Base.BaseClase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.setpdefinition.GettingPaid;

public class Prefernces extends BaseClase{
	public PropertiesReader propertiyReader =null ;
	public Faker faker;
	public  static Logger log;
	public Prefernces(){
		log= LogManager.getLogger(Prefernces.class);
		propertiyReader=new PropertiesReader();
		faker=new Faker();
	}
	@Given("user launch the browser and Maximize window")
	public void user_launch_the_browser_and_Maximize_window() throws Exception {
		driver= launchBrowser(propertiyReader.getProperty("browser"));
		
	}

	@When("user to hit the Shopdot Url")
	public void user_to_hit_the_Shopdot_Url() throws InterruptedException {
		launchurl("https://qa2.shopdotapp.com/login");
		
	}

	@When("user Login to the shopdot application")
	public void user_Login_to_the_shopdot_application() {
	   driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(propertiyReader.getProperty("PREFERENCE_User"));
	   driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Welcome6@123");
	   driver.findElement(By.xpath("//div[@class='form-input mt-5']")).click();
	}

	
	@When("user clicks on Preferences menu from Settings")
	public void user_clicks_on_Preferences_menu_from_Settings() throws InterruptedException {

		Timewait();
//	   driver.findElement(By.xpath("//a[normalize-space()='Preferences']")).click();
	   try {

			WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Preferences']"));
           // Attempt to click the element
           element.click();
           
       } catch (Exception e) {
           // Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
       	WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Preferences']"));
       	JavascriptExecutor executor = (JavascriptExecutor)driver;
       	
//           JavascriptExecutor executor = (JavascriptExecutor) driver;
           executor.executeScript("arguments[0].click();", element);
       }
	   
	   
	   System.out.println(driver.getCurrentUrl());
	   
	   
	   
	}

	@When("Display Preferences menu page")
	public void display_Preferences_menu_page() throws InterruptedException {
		
	    String gettext = driver.findElement(By.xpath("//h1[@class='m-0']")).getText();
	    Assert.assertEquals(gettext, "Preferences");
	    log.info("Displaying page is: " + gettext);
	}

	@When("wherein the Wholesale Pricing field shows default is value{int}%")
	public void wherein_the_Wholesale_Pricing_field_shows_default_is_value(Integer int1) throws IOException {
	    screenShot("wholeslae");
	    String text = driver.findElement(By.xpath("//span[@id='wpValue']")).getText();
	   log.info("The Wholesale Pricing Default Value is: "+ text);
	}
	@When("wherein the Inventory Buffer field shows default is value{int}%")
	public void wherein_the_Inventory_Buffer_field_shows_default_is_value(Integer int1) {
	    String inventory = driver.findElement(By.xpath("//label[@id='ibValue']")).getText();
	    Assert.assertEquals(inventory, "70");
	   log.info("The Inventory Buffer Default Value is: "+ inventory);
	}
	
	@When("wherein the Retail Pricing field selects {string} by default")
	public void wherein_the_Retail_Pricing_field_selects_Enforce_retail_price_selected_by_default(String Text) throws IOException {
	    screenShot("retailer pr");
//		String selected = driver.findElement(By.className("select__input-container css-19bb58m")).getText();
//
//		Assert.assertEquals(selected, Text);
//        log.info("The Default option of Retail Pricing is : " + selected);
    }
	
	@When("wherein the Return and Refund Policy selected by default {string}")
	public void wherein_the_Return_and_Refund_Policy_selected_by_default(String text) {
//		String returnPolicy = String.valueOf(driver.findElement(By.name("retunRefundPolicy")).isSelected());
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Returns and refunds are accepted on a case-by-case')]"));
		element.getText();
		log.info(element);
		boolean isClicked = element.isSelected();
		if (isClicked) {
			log.info("Element has been clicked");
		} else {
			log.info("Element has not been clicked");
		}
//		Assert.assertEquals(returnPolicy, text);
//		log.info("The Default option is : " + returnPolicy);
	    
	    
	}
	
	@When("user clicks on the Save button without enter any data on the mandatory field")
	public void user_clicks_on_the_Save_button_without_enter_any_data_on_the_mandatory_field() {
	    driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	}

	@Then("user should see the validation error message below the fields")
	public void user_should_see_the_validation_error_message_below_the_fields() throws IOException {
	    screenShot("save");
	    String address = driver.findElement(By.xpath("//span[normalize-space()='Address 1 is required.']")).getText();
	    Assert.assertEquals(address, "Address 1 is required.");
	    System.out.println("Address error message is: "+ address);
	    
	    String country = driver.findElement(By.xpath("//span[normalize-space()='Country is required.']")).getText();
	    Assert.assertEquals(country, "Country is required.");
	    System.out.println("country error message is: "+ country);
	    
	    String state = driver.findElement(By.xpath("//span[normalize-space()='State is required.']")).getText();
	    Assert.assertEquals(state, "State is required.");
	    System.out.println("state error message is: " +state);
	    
	    String city = driver.findElement(By.xpath("//span[normalize-space()='please enter letters only.']")).getText();
	    Assert.assertEquals(city, "please enter letters only.");
	    System.out.println("city error message is: "+ city);
	    
	    String zip = driver.findElement(By.xpath("//span[normalize-space()='Please fill this field']")).getText();
	    Assert.assertEquals(zip, "Please fill this field");
	    System.out.println("zip error message is: " + zip);
	    
	    String shipping = driver.findElement(By.xpath("//span[normalize-space()='Shipping fee is required.']")).getText();
	    Assert.assertEquals(shipping, "Shipping fee is required.");
	    System.out.println("shipping error message is: "+ shipping);
	    
	    String Incremental = driver.findElement(By.xpath("//span[normalize-space()='Incremental fee is required.']")).getText();
	    Assert.assertEquals(Incremental, "Incremental fee is required.");
	    System.out.println("Incremental error message is: " +Incremental);
	    
	    String DefaultDays = driver.findElement(By.xpath("//span[contains(text(),'Days to fultill')]")).getText();
	    Assert.assertEquals(DefaultDays, "Days to fulill  is required.");
	    System.out.println("DefaultDays error message is: " +DefaultDays);
	    
	    
	}

	@Then("User should not move to the next page")
	public void user_should_not_move_to_the_next_page() {
	    String np = driver.findElement(By.xpath("//h1[normalize-space()='Preferences']")).getText();
	    boolean matches = np.matches(np);
	    System.out.println(np);
	    Assert.assertEquals(np, "Preferences");
	    System.out.println("The page is in the: " + np);
	}

//	002

	@When("user clear  the dafult data in the Inventory Buffer on Preferences menu Page")
	public void user_clear_the_dafult_data_in_the_Inventory_Buffer_on_Preferences_menu_Page() throws InterruptedException {
	    typeText(null, driver.findElement(By.xpath("//input[@name='inventoryPercentage']")));
	}
	
	
	
	@When("user change the value in the Wholesale Price Percentage on the Wholesale Pricing field")
	public void user_change_the_value_in_the_Wholesale_Price_Percentage_on_the_Wholesale_Pricing_field() throws InterruptedException {
	    typeText("30", driver.findElement(By.xpath("//input[@name='wholesalePercentage']"))); ;
	    
	    
	}

	@When("user change the default option from the Retail Pricing")
	public void user_change_the_default_option_from_the_Retail_Pricing() throws InterruptedException {
		
	    driver.findElement(By.xpath("//div[@class='form-input preferences-item']//div[@class='select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer']//*[name()='svg']")).click();
//	    waitforElementVisiblity(driver.findElement(By.xpath("//div[text()='Allow for flexible retail pricing']")));
	   Thread.sleep(2000);
//	   driver.findElement(By.xpath("//div[text()='Allow for flexible retail pricing']")).click();
	    
	   try {

			WebElement element = driver.findElement(By.xpath("//div[text()='Allow for flexible retail pricing']"));
          // Attempt to click the element
          element.click();
          
      } catch (Exception e) {
          // Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
      	WebElement element = driver.findElement(By.xpath("//div[text()='Allow for flexible retail pricing']"));
      	JavascriptExecutor executor = (JavascriptExecutor)driver;
      	
//          JavascriptExecutor executor = (JavascriptExecutor) driver;
          executor.executeScript("arguments[0].click();", element);
      }
	}

	@When("user change the value in the Inventory Buffer Percentage on the Inventory Buffer field")
	public void user_change_the_value_in_the_Inventory_Buffer_Percentage_on_the_Inventory_Buffer_field() throws InterruptedException {
		 
		typeText("50", driver.findElement(By.xpath("//input[@name='inventoryPercentage']")));
	}

	@When("user change the default option from the Return and Refund Policy")
	public void user_change_the_default_option_from_the_Return_and_Refund_Policy() throws InterruptedException {
		 
		driver.findElement(By.xpath("//div[@class='preferences_info mt-4']//label[1]//div[1]")).click();
	}

	@When("user enter data on  the Requirements for retailers who want to connect with your brand field")
	public void user_enter_data_on_the_Requirements_for_retailers_who_want_to_connect_with_your_brand_field() throws InterruptedException {
		 
		
		typeText("testing",driver.findElement(By.xpath("//textarea[@name='requirementsForRetailers']")));
	}

	@When("user enter address in the Address{int} field")
	public void user_enter_address_in_the_Address_field(Integer int1) throws InterruptedException {
		typeText("Testing Address", driver.findElement(By.xpath("//input[@name='address1']")));

//	    driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Testing Address1");
	}

	@When("user selects Country from the Country field")
	public void user_selects_Country_from_the_Country_field() throws InterruptedException, AWTException {
		
		driver.findElement(By.xpath("//div[@class='shipping_info preferences_info mt-4']//div[@class='form-area']//div[1]//div[1]//div[1]//div[2]//div[1]")).click();
		Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	    
	}

	@When("user selects State from the State field")
	public void user_selects_State_from_the_State_field() throws InterruptedException, AWTException {
		
	    driver.findElement(By.xpath("//input[@id='react-select-4-input']")).click();
	    Thread.sleep(2000);
	    Robot r = new Robot();
	    for (int i = 1; i < 3; i++) {
	    	r.keyPress(KeyEvent.VK_DOWN);
		    r.keyRelease(KeyEvent.VK_DOWN);
		}
	    
	    
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user enter city name on the City field")
	public void user_enter_city_name_on_the_City_field() throws InterruptedException {
	    
	    typeText("NewYork", driver.findElement(By.xpath("//input[@name='city']")));
	}

	@When("user enter data on the Zip field")
	public void user_enter_data_on_the_Zip_field() {
		driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("12340");
	   
	}

	@When("user enter data in the Shipping fee field")
	public void user_enter_data_in_the_Shipping_fee_field() throws InterruptedException {
		
		typeText("50", driver.findElement(By.xpath("//input[@name='shippingfee']")));	
	    
	}

	@When("user enter data in the Incremental fee field")
	public void user_enter_data_in_the_Incremental_fee_field() throws InterruptedException {
		
		typeText("50", driver.findElement(By.xpath("//input[@name='incrementalfee']")));
	}

	@When("user selects days from the Days to fulfill field")
	public void user_selects_days_from_the_Days_to_fulfill_field() throws AWTException, InterruptedException {
	    driver.findElement(By.xpath("//div[@class='category-form-input tooltip-input mt-4']//div[@class='select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer']//*[name()='svg']")).click();
	    Thread.sleep(1500);
	    Robot r = new Robot();
	    for (int i = 1; i < 2; i++) {
	    	r.keyPress(KeyEvent.VK_DOWN);
		    r.keyRelease(KeyEvent.VK_DOWN);
		}
	    
	    
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	@When("user click in the Save button on preferences page")
	public void user_click_in_the_Save_button_on_preferences_page() {
	    driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	    
	    
	}
	
	@Then("user should see the Sucessful message in the page")
	public void user_should_see_the_Sucessful_message_in_the_page() throws InterruptedException, IOException {
	   
		String sucess = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		System.out.println("The message displayed on the screen is" + sucess);
		Assert.assertEquals(sucess.toLowerCase(), "Your changes have been saved.".toLowerCase());
		log.info("The message displayed on the screen is" + sucess);

	}
	@Then("User is automatically moved to the next page, which is Integrations")
	public void user_is_automatically_moved_to_the_next_page_which_is_Integrations() {
		String Integration = driver.findElement(By.xpath("//h2[normalize-space()='Integrations']")).getText();
	    Assert.assertEquals(Integration, "Integrations");
	    System.out.println(Integration);
	}


}
