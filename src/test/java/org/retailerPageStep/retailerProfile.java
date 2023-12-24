package org.retailerPageStep;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

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

public class retailerProfile extends BaseClase{
	public PropertiesReader propertiyReader =null ;
	public Faker faker;
	public  static Logger log;
	public retailerProfile(){
		log= LogManager.getLogger(retailerProfile.class);
		propertiyReader=new PropertiesReader();
		faker=new Faker();
	}
	@Given("User Launch the Browser and Maximize the Window")
	public void user_Launch_the_Browser_and_Maximize_the_Window() throws Exception {
		driver=  launchBrowser("chrome");
		faker=new Faker();
	}

	@When("User hit the Shopdot URL")
	public void user_hit_the_Shopdot_URL() {
		launchurl("https://qa2.shopdotapp.com/login");
	}

	@When("User Login to the ShopDot Application")
	public void user_Login_to_the_ShopDot_Application() {
		driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(propertiyReader.getProperty("RetailerSignIn"));
		   driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Welcome6@123");
		   driver.findElement(By.xpath("//div[@class='form-input mt-5']")).click();

	}

//	@When("User navigate to the Getting Started Screen")
//	public void user_navigate_to_the_Getting_Started_Screen() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new cucumber.api.PendingException();
//	}

//	@When("User Click on the Setting button")
//	public void user_Click_on_the_Setting_button() {
//
//		driver.findElement(By.xpath("//a[@class='ob-link']")).click();

//	  if (driver.getCurrentUrl().equalsIgnoreCase("https://qa2.shopdotapp.com/retailer/dashboard")) {
//		  mouseHoverToElement(driver.findElement(By.xpath("(//span[@class='icon'])[2]")));
//		  waituntilClickable(driver.findElement(By.xpath("//a[normalize-space()='Settings']")));

//	  }
//  }


	@When("Display the Retailer Profile Menu Page")
	public void display_the_Retailer_Profile_Menu_Page() {
		 String title = driver.findElement(By.xpath("//h1[normalize-space()='Retailer Profile']")).getText();
		   Assert.assertEquals(title, "Retailer Profile");
		   System.out.println(title);

	}

	@When("user enter Company name in Company name field")
	public void user_enter_Company_name_in_Company_name_field() {
		typeText(faker.company().name()+"test", driver.findElement(By.xpath("//input[@placeholder='Enter the name of your company']")));
	}

	@When("user enter the email in the Contact email field")
	public void user_enter_the_email_in_the_Contact_email_field() {
		
		typeText("shopdottesting@yopmail.com", driver.findElement(By.xpath("//input[@placeholder='email@xyz.com']")));
	}

	@When("user phone number in the Contact phone number field")
	public void user_phone_number_in_the_Contact_phone_number_field() {
		typeText("1234567890", driver.findElement(By.xpath("//input[@placeholder='(XXX) XXX-XXXX']")));
	}

	@When("user uplod the logo")
	public void user_uplod_the_logo() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("(//input[@type='file'])[1]")).sendKeys("C:/Users/Emman/Downloads/images (1).jpeg");
//	    driver.findElement(By.xpath("//img[@alt='Uploaded Logo']")).click();
		
//		WebElement fileInput = driver.findElement(By.xpath("//img[@alt='Uploaded Logo']")); 
//	    fileInput.click();  
//	    
//		StringSelection ss = new StringSelection("C:\\Users\\Emman\\Downloads\\testing.jpg");
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Robot r = new Robot(); 
//		r.delay(2000);
//		
		Thread.sleep(1500);
	}

	@When("user enter the Retailer name")
	public void user_enter_the_Retailer_name() {
	   typeText("Retailer Testing", driver.findElement(By.xpath("//input[@name='retailerName']")));
	}

	@When("user enter website on the Retailer website field")
	public void user_enter_website_on_the_Retailer_website_field() {
	   typeText("www.test.com", driver.findElement(By.xpath("//input[@name='retailerWebsite']")));
	}

	@When("user slect one option from the Retailer category field")
	public void user_slect_one_option_from_the_Retailer_category_field() throws InterruptedException, AWTException {
	    driver.findElement(By.xpath("//input[@id='react-select-2-input']")).click();
	    Thread.sleep(1500);
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user select Retailer values")
	public void user_select_Retailer_values() {
		driver.findElement(By.xpath("//span[normalize-space()='BIPOC Owned']")).click();
	    driver.findElement(By.xpath("//div[3]//label[1]//div[1]")).click();
	    driver.findElement(By.xpath("//div[10]//label[1]//div[1]")).click();
	}

	@When("enter data on the About the retailer field")
	public void enter_data_on_the_About_the_retailer_field() {
		driver.findElement(By.xpath("//textarea[@placeholder='Enter retailer description']")).sendKeys("Retailer profile testing");
	}

	@When("user enter the link on the Add a Youtube or Vimeo video link field")
	public void user_enter_the_link_on_the_Add_a_Youtube_or_Vimeo_video_link_field() {
		typeText("https://www.youtube.com/", driver.findElement(By.xpath("//input[@placeholder='Enter link']")));
	}

	@When("user upload the store photo")
	public void user_upload_the_store_photo() throws InterruptedException, AWTException {
       driver.findElement(By.xpath("(//input[@type='file'])[2]")).sendKeys("C:/Users/Emman/Downloads/images (1).png");
      
	}

	@When("user enter address")
	public void user_enter_address() {
		driver.findElement(By.xpath("//input[@placeholder='Suite/Building number, floor number, Street number etc…']")).sendKeys("Testing Address");
		driver.findElement(By.xpath("//input[@placeholder='Other address details, if needed']")).sendKeys("Testing Address2");
	}

	@When("user select the Country")
	public void user_select_the_Country() throws InterruptedException, AWTException {
//		Thread.sleep(1500);
//	    driver.findElement(By.xpath("//div[@id='react-select-3-placeholder']")).click();
	    
	   
	    
	    try {

			WebElement element = driver.findElement(By.xpath("//div[@class='select__value-container css-hlgwow']"));
           // Attempt to click the element
           element.click();
           
       } catch (Exception e) {
           // Handle the exception, e.g., wait for the overlay to disappear or use JavaScript to click
       	WebElement element = driver.findElement(By.xpath("//div[@class='select__value-container css-hlgwow']"));
       	JavascriptExecutor executor = (JavascriptExecutor)driver;
       	
//           JavascriptExecutor executor = (JavascriptExecutor) driver;
           executor.executeScript("arguments[0].click();", element);
       }
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user select the State")
	public void user_select_the_State() throws AWTException, InterruptedException {
		Thread.sleep(1500);
	    driver.findElement(By.xpath("//input[@id='react-select-4-input']")).click();
	    Thread.sleep(1000);
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("user enter City")
	public void user_enter_City() {
		driver.findElement(By.xpath("//input[@placeholder='Enter your city name']")).sendKeys("New Jerresy");
	}

	@When("user enter ZIP")
	public void user_enter_ZIP() {
		driver.findElement(By.xpath("//input[@placeholder='12345']")).sendKeys("12345");
	}

	@When("user click on the Save button")
	public void user_click_on_the_Save_button() {
	    driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	}

	@Then("user should able to see the sucessful message on the Page")
	public void user_should_able_to_see_the_sucessful_message_on_the_Page() {
		String msg = driver.findElement(By.xpath("//div[contains(text(),'Your changes have been saved.')]")).getText();
		Assert.assertEquals("Your changes have been saved.",msg);
		System.out.println("the displayed msg is: " + msg);
		
		
	    
	}


}
