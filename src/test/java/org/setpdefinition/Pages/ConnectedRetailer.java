package org.setpdefinition.Pages;

import Utils.PropertiesReader;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Base.BaseClase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class ConnectedRetailer extends BaseClase {
    public PropertiesReader propertiyReader =null ;
    public Faker faker;
    public  static Logger log;
    public String typechare;
    public List<WebElement> afterSearchRetailerList;
    public ConnectedRetailer(){
        log= LogManager.getLogger(ConnectedRetailer.class);
        propertiyReader=new PropertiesReader();
        faker=new Faker();
    }
    @When("Brand clicks on {string} option from Retailers menu")
    public void brand_clicks_on_option_from_Retailers_menu(String ConnectedRetailers) {
        mouseHoverToElement(driver.findElement(By.xpath("//a[normalize-space()='Retailers']")));
        waituntilClickable(driver.findElement(By.xpath("//a[normalize-space()='Connected Retailers']")));
    }

    @Then("the list of approved retailers is displayed in alphabetical order by Retailer Name")
    public void the_list_of_approved_retailers_is_displayed_in_alphabetical_order_by_Retailer_Name() throws IOException, InterruptedException {
        screenShot("alp");
    }

    @And("the total number of connected retailers for that brand is displayed on the top next to Connected Retailers")
    public void theTotalNumberOfConnectedRetailersForThatBrandIsDisplayedOnTheTopNextToConnectedRetailers() throws InterruptedException {
        Thread.sleep(3000);
        String text = driver.findElement(By.xpath("//h1[normalize-space()='Connected Retailers']")).getText();
        log.info(text);
        String text1 = driver.findElement(By.xpath("//div[@class='number']")).getText();
        log.info("The number of connected retailer: " + text1);
    }

    @When("user enters characters in the search bar")
    public void userEntersCharactersInTheSearchBar() {

        List<WebElement> retailerList = driver.findElements(By.xpath("//div[@class='store']"));
        typechare = retailerList.get(generateRandomNumber(0, retailerList.size()-1)).getText().substring(0, 3);
        log.info("Entering the Keyword Randomly in the Connected Retailer : " + typechare );
        typeText(typechare,driver.findElement(By.xpath("//input[@type='text']")));

    }

    @And("the Application displays only those approved retailers that match the search keyword")
    public void theApplicationDisplaysOnlyThoseApprovedRetailersThatMatchTheSearchKeyword() throws InterruptedException {
        Thread.sleep(3000);
        afterSearchRetailerList = driver.findElements(By.xpath("//div[@class='store']"));
        String retailerName = afterSearchRetailerList.get(generateRandomNumber(0, afterSearchRetailerList.size()-1)).getText();
        log.info("The Retailer displayed the char that match the search word : " + retailerName);
        Assert.assertTrue(retailerName.toLowerCase().contains(typechare.toLowerCase()));

    }

    @And("the Application displays the result count")
    public void theApplicationDisplaysTheResultCount() {
        String number = driver.findElement(By.xpath("//div[@class='number']")).getText();
        log.info("The number Connected retailer is: " + number);
    }

    @When("Brand selects retailer category as filter")
    public void brandSelectsRetailerCategoryAsFilter() throws InterruptedException {
        driver.findElement(By.xpath("(//div[@class='overSelect'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[normalize-space()='Apparel Boutique']")).click();
        log.info("The selected option is : " + driver.findElement(By.xpath("//label[normalize-space()='Apparel Boutique']")).getText());
    }

    @When("Brand selects state as filter")
    public void brandSelectsStateAsFilter() throws InterruptedException {
        driver.findElement(By.xpath("(//div[@class='overSelect'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[normalize-space()='Colorado']")).click();
        log.info("The selected State option is : " + driver.findElement(By.xpath("//label[normalize-space()='Colorado']")).getText());

    }


    @Then("the following screen will be displayed: {string}")
    public void theFollowingScreenWillBeDisplayed(String Text) {
        Assert.assertEquals(driver.findElement(By.xpath("//h3[normalize-space()='Currently you have no connected retailers.']")).getText().trim(), Text);
        String inviteRetailer = driver.findElement(By.xpath("//button[@class='button me-2']")).getText();
        log.info("The Displayed button is: " + inviteRetailer);
        String requestAccess = driver.findElement(By.xpath("//button[normalize-space()='View Requests for Access']")).getText();
        log.info("The Displayed button is: " + requestAccess);
    }
    @And("the Application displays the result count \\(which is {int})")
    public void theApplicationDisplaysTheResultCountWhichIs(int arg0) {
        String number = driver.findElement(By.xpath("//div[@class='number']")).getText();
        log.info("The number Connected retailer is: " + number);

    }

    @When("the user click on the {string} buttons")
    public void theUserClickOnTheButtons(String text) {


        if (text.equalsIgnoreCase("Invite Retailers")){
            log.info("Clicking on the: " + text + "option");
            driver.findElements(By.xpath("//button[text()='"+text+"']")).get(1).click();

        }
        else{
            log.info("Clicking on the: " + text + " option");
           driver.findElement((By.xpath("//button[text()='"+text+"']"))).click();
        }

    }

    @Then("referral link pop Displays")
    public void referralLinkPopDisplays() {
        String referralLink = driver.findElement(By.xpath("//h3[normalize-space()='Share this referral link with your retailers.']")).getText();
        log.info("The Screen is on the: " + referralLink);
        String value = driver.findElement(By.xpath("//input[@type='email']")).getAttribute("value");
        log.info("The Value in the email field is: " + value);

    }

    @When("Brand enters non existing Retailer name in the search bar")
    public void brandEntersNonExistingProductNameInTheSearchBar() {
        driver.findElement(By.xpath("//input[@placeholder='Search retailers']")).sendKeys(faker.name().firstName());
    }

    @Then("the following message is displayed in the table {string}")
    public void theFollowingMessageIsDisplayedInTheTableThereAreNoApprovedRetailersThatMeetYourCriteria(String text) {

       Assert.assertEquals(driver.findElement(By.xpath("//h3[normalize-space()='Currently you have no connected retailers.']")).getText().trim(), text);
       log.info("Waring Message: " + driver.findElement(By.xpath("//h3[normalize-space()='Currently you have no connected retailers.']")).getText());
    }


    @And("user Login into the SHOPDOT application")
    public void userLoginIntoTheSHOPDOTApplication() {
        propertiyReader.setProperty("requestforAccess_NewUser","testsample2@yopmail.com");
        log.info("Loging with the user which is dont have the Request access");

        logInShopDot(propertiyReader.getProperty("requestforAccess_NewUser"),propertiyReader.getProperty("password"));

    }

    @Then("user should navigate to the Requests for Access Screen{string}")
    public void userShouldNavigateToTheRequestsForAccessScreen(String text) {
        log.info("The screen is on the: " + text);
       Assert.assertEquals(text,driver.findElement(By.xpath("//h1[text()='Requests for Access']")).getText().trim());
    }

}
