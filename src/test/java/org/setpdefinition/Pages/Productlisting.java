package org.setpdefinition.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import Utils.ConstentData;
import Utils.PropertiesReader;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import org.Base.BaseClase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.pojo.pojoSignInpage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Productlisting extends BaseClase{
	public String searchbar;
	public List<WebElement> afterSearchProductList;
	public PropertiesReader propertiyReader =null ;
	public Faker faker;
	public  static Logger log;
	public Productlisting(){
		log= LogManager.getLogger(Productlisting.class);
		propertiyReader=new PropertiesReader();
		faker=new Faker();
	}
	
	@Given("User lauch the browser and Maximize the Window")
	public void user_lauch_the_browser_and_Maximize_the_Window() throws Exception {
		driver = launchBrowser("chrome");
	}

	@When("User to hit the ShopDot URL")
	public void user_to_hit_the_ShopDot_URL() {
		launchurl("https://qa2.shopdotapp.com/login");
	}

	@And("User login to the ShopDot Application")
	public void userLoginToTheShopDotApplication() {
		pojoSignInpage g = new pojoSignInpage(driver);
		sendText(g.getEmail(), propertiyReader.getProperty("ProductlistingLogin"));
		sendText(g.getPassword(), "Welcome6@123");
		clickBtn(g.getLogin());
	}
// this is for new user
	@When("User login to the Shopdot Application")
	public void user_login_to_the_ShopDot_Application() {

		propertiyReader.setProperty("ProductlistingNewLogin","testsample27@yopmail.com");

		logInShopDot(propertiyReader.getProperty("ProductlistingNewLogin"),propertiyReader.getProperty("password"));

}

	@When("User clicks on the products button")
	public void user_clicks_on_the_products_button() throws InterruptedException {
		Thread.sleep(1500);
		WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Products']"));
		// Perform an action causing the page to refresh or update
		element = driver.findElement(By.xpath("//a[normalize-space()='Products']")); // Re-find the element
		element.click(); // Perform the action again

//	    driver.findElement(By.xpath("//a[normalize-space()='Products']")).click();
	}

	@When("Displays the Products Listing Screen")
	public void displays_the_Products_Listing_Screen() {
		String dis = driver.findElement(By.xpath("//h1[normalize-space()='Products']")).getText();
		Assert.assertEquals(dis, "Products");
	    log.info("The page is displaying in: " + dis + "Listing Page");
	    
	    String text = driver.findElement(By.xpath("//div[contains(@class,'indicator_text')]")).getText();
	    log.info(text);
	    
	}
	
//001
	@When("Brand clicks on Products Listing menu")
	public void brand_clicks_on_Products_Listing_menu() {
		driver.findElement(By.xpath("//a[normalize-space()='Products']")).click();
		String no = driver.findElement(By.xpath("//div[@class='number']")).getText();
	    Assert.assertEquals(no, false);
	    System.out.println("No of Products is: " + no);
	}

	@Then("the products from the E-Commerce website that are initially synced will be listed")
	public void the_products_from_the_E_Commerce_website_i_e_Shopify_that_are_initially_synced_will_be_listed() throws IOException, InterruptedException {
		Thread.sleep(6000);
		String no = driver.findElement(By.xpath("//div[@class='number']")).getText();
	    screenShot("THEIma");
	    log.info("No of Products is: " + no);
	}
	
	
//	002
	@When("user selects the Tags")
	public void user_selects_the_Tags() throws InterruptedException, AWTException {
		Thread.sleep(1000);

	    //	    -- if already added
	    driver.findElement(By.xpath("//p[@class='value_added cursor-pointer']")).click(); 
	    
//	    if fresh 
//	    driver.findElement(By.xpath("//p[@class='add-item-label add-tags cursor-pointer']")).click();
	    
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@placeholder='Tag name']")).sendKeys("unisex");
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	    
	    driver.findElement(By.xpath("//input[@placeholder='Tag name']")).sendKeys("child");
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	    
	    driver.findElement(By.xpath("//button[normalize-space()='Save Changes']")).click();
	}
	

	@When("displays sucessful message")
	public void displays_sucessful_message() throws InterruptedException {
		Thread.sleep(2000);
	    String pop = driver.findElement(By.xpath("//div[contains(text(),'Product tag updated successfully')]")).getText();
	    log.info("Tag Message: " + pop);
	}

	@When("user selects Category")
	public void user_selects_Category() throws InterruptedException {
		Thread.sleep(3000);

		//	    for fresh
//		driver.findElement(By.xpath("//p[@class='add-item-label add-category cursor-pointer']")).click();

		//		for exiting
		driver.findElement(By.xpath("//p[normalize-space()='Men']")).click();
//		
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@id='Men']//div[@class='checkbox-text']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Accessories')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Ties & Pocket Squares')]")).click();
		
		driver.findElement(By.xpath("//button[@class='button button-orange-dark']")).click();
	}

	@When("again displays sucessful message")
	public void again_displays_sucessful_message() throws InterruptedException {
		Thread.sleep(1500);
	    String popup = driver.findElement(By.xpath("//div[@role='alert']")).getText();
	    log.info("Category message: " + popup);
	}

	@When("the status button become enable")
	public void the_status_button_become_enable() throws InterruptedException {
		Thread.sleep(2000);
	    boolean status = driver.findElement(By.xpath("//span[@class='off']")).isEnabled();
		assertTrue(status);
	}

	@When("the user click on the Inactive button")
	public void the_user_click_on_the_Inactive_button() {
		boolean status = driver.findElement(By.xpath("//span[@class='off']")).isEnabled();
		if (status){
			log.info("The status is: " + status);
			driver.findElement(By.xpath("//span[@class='off']")).click();

		}
		else {
			log.info("The button is " + status);
		}
	}

	@Then("congratulation Pop up displays")
	public void congratulation_Pop_up_displays() {
	    String con = driver.findElement(By.xpath("//h1[normalize-space()='Congratulations!']")).getText();
	    Assert.assertEquals(con, "Congratulations!");
	    log.info("Con message: " + con);
	    String textc = driver.findElement(By.xpath("//p[@class='mb-4']")).getText();
	    log.info("Message: " + textc);
	    
	    driver.findElement(By.xpath("//img[@alt='close']")).click();
	}

	@Then("the Inactive changes to Active status")
	public void the_Inactive_changes_to_Active_status() {
	    String act = driver.findElement(By.xpath("//span[@class='on']")).getText();
	    log.info("The Status is: " + act);
	}
	@When("user enters product in the search bar")
	public void userEntersProductInTheSearchBar() {
		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='my_list-product']"));
		 searchbar = productList.get(generateRandomNumber(0, productList.size() - 1)).getText().substring(0, 3);
		log.info("Entering the Keyword Randomly in the Connected Retailer : " + searchbar);
		typeText(searchbar,driver.findElement(By.xpath("//input[@type='text']")));
	}
	@Then("the Application displays only those Products that match the search keyword")
	public void theApplicationDisplaysOnlyThoseProductsThatMatchTheSearchKeyword() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> afterSearchProductList = driver.findElements(By.xpath("//div[@class='my_list-product']"));
		String searchName = afterSearchProductList.get(generateRandomNumber(0, afterSearchProductList.size()-1)).getText();
		log.info("The Retailer displayed the char that match the search word : " + searchName);
		Assert.assertTrue(searchName.toLowerCase().contains(searchbar.toLowerCase()));

	}

	@When("Brand enters non existing Product name in the search bar")
	public void brandEntersNonExistingProductNameInTheSearchBar() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search product name or SKU']")).sendKeys(faker.name().firstName());
	}

	@Then("the following message is displayed in the table:{string}")
	public void theFollowingMessageIsDisplayedInTheTableThereAreNoProductsThatMeetYourCriteria(String text) throws InterruptedException {
		WebElement noProductError = driver.findElement(By.xpath("//p[text()='There are no products that meet your criteria.']"));
		log.info("Waring Message Before: " + noProductError.getText());
		assertEquals(noProductError.getText().trim(), text);
		
	}

	@And("user add the Tags for {string}")
	public void userAddTheTagsFor(String text) {
		driver.findElement(By.xpath("//p[text()='"+text+"']/parent::div/parent::div/parent::td/following-sibling::td[3]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Tag name']")).sendKeys(getRandomStringFromArray(ConstentData.TAGS_FOR_PRODUCTS_ACTIVATION));
		driver.findElement(By.xpath("//input[@placeholder='Tag name']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[@class='icon-size']")).click();

	}
	@And("user selects Category for {string}")
	public void userSelectsCategoryFor(String text1) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[text()='"+text1+"']/parent::div/parent::div/parent::td/following-sibling::td[2]")).click();

		driver.findElement(By.xpath("//div[@id='Men']//div[@class='checkbox-text']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Accessories')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Ties & Pocket Squares')]")).click();

		driver.findElement(By.xpath("//button[@class='button button-orange-dark']")).click();
	}


	@When("Brand click on the Download All Products button")
	public void brandClickOnTheDownloadAllProductsButton() throws InterruptedException {
		Thread.sleep(3000);
		clickBtn(driver.findElement(By.xpath("//button[@class='button button-blue small']")));

		assertTrue(waitforElementVisiblity(driver.findElement(By.xpath("//div[text()='All products will be downloaded into an Excel format and will be sent to your email when the file is ready']"))).isDisplayed());
	}

	@Then("Pop-up will display on the screen")
	public void popUpWillDisplayOnTheScreen() {
		assertTrue(driver.findElement(By.xpath("//div[text()='All products will be downloaded into an Excel format and will be sent to your email when the file is ready']")).isDisplayed());
	log.info(driver.findElement(By.xpath("//div[text()='All products will be downloaded into an Excel format and will be sent to your email when the file is ready']")).getText());


	}

	@When("Brand click on the Active Button")
	public void brandClickOnTheActiveButton() {
		clickBtn(driver.findElement(By.xpath("//a[normalize-space()='Active']")));

	}

	@Then("Displays only the Active Products")
	public void displaysOnlyTheActiveProducts() {
		List<WebElement> activeProducts = driver.findElements(By.xpath("//p[@class='my_list-product-title cursor-pointer']/parent::div/parent::div/parent::td/following-sibling::td[1]"));
		for (WebElement activeProduct:activeProducts) {

			assertTrue(activeProduct.getText().contains("Active"));
		}
		log.info("The No of Active products is: " + activeProducts.size());
	}

	@When("Brand click on the Inactive Button")
	public void brandClickOnTheInactiveButton() {
		clickBtn(driver.findElement(By.xpath("//a[normalize-space()='Inactive']")));
	}

	@Then("Displays only the Inactive Products")
	public void displaysOnlyTheInactiveProducts() {
		List<WebElement> InactiveProducts = driver.findElements(By.xpath("//p[@class='my_list-product-title cursor-pointer']/parent::div/parent::div/parent::td/following-sibling::td[1]"));
		for (WebElement InactiveProduct:InactiveProducts) {

			assertTrue(InactiveProduct.getText().contains("Inactive"));
		}
		log.info("The No of Inactive products is: " + InactiveProducts.size());
	}


}
