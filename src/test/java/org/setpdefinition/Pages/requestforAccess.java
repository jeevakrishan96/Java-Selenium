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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class requestforAccess extends BaseClase {
    public PropertiesReader propertiyReader =null ;
    public Faker faker;
    public  static Logger log;
    public requestforAccess(){
        log= LogManager.getLogger(requestforAccess.class);
        propertiyReader=new PropertiesReader();
        faker=new Faker();
    }

    @And("user Login to the SHOPDOT application")
    public void userLoginToTheSHOPDOTApplication() {

        driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(propertiyReader.getProperty("requestforAccess_User"));
        driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Welcome6@123");
        driver.findElement(By.xpath("//div[@class='form-input mt-5']")).click();

    }
    @And("the retailer clicks on {string} under Retailers main menu")
    public void theRetailerClicksOnUnderRetailersMainMenu(String arg0) {

        mouseHoverToElement(driver.findElement(By.xpath("//a[normalize-space()='Retailers']")));
       waituntilClickable(driver.findElement(By.xpath("//a[normalize-space()='Requests for Access']")));

    }

    @Then("the Application displays the list of retailers requesting access from the brand")
    public void theApplicationDisplaysTheListOfRetailersRequestingAccessFromTheBrand() throws InterruptedException {
        Thread.sleep(6000);
        WebElement requesacess = driver.findElement(By.xpath("//h1[normalize-space()='Requests for Access']"));
        assertEquals(requesacess.getText(), "Requests for Access");
        log.info("The Displayed scree is : " + requesacess.getText());

        WebElement total = driver.findElement(By.xpath("//div[@class='number']"));
        log.info("The total no of Brands is : " + total.getText());
    }

    @And("the sorting order is Pending requests followed by Connected requests and then Declined requests")
    public void theSortingOrderIsPendingRequestsFollowedByConnectedRequestsAndThenDeclinedRequests() throws IOException {
//        driver.findElement(By.xpath(""));
        screenShot("BP");
    }


    @And("the retailer clicks on the View or Edit button from {int}dot menu")
    public void theRetailerClicksOnTheViewOrEditButtonFromDotMenu(int arg0) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='dropdown_header'])[9]")).click();
        driver.findElement(By.xpath("(//a[text()='View/Edit'])[5]")).click();

    }

    @Then("it should navigate to the Retailer profile screen")
    public void itShouldNavigateToTheRetailerProfileScreen() {
        String currentUrl = driver.getCurrentUrl();
        if(driver.getCurrentUrl().contains("https://qa2.shopdotapp.com/brand/retailer-profile/76")){
            log.info("The displaying screen is Brands Profile : " + currentUrl);
        }
        else {
            String currentUrl1 = driver.getCurrentUrl();
            log.info("The page is in the: " + currentUrl1);
        }
    }


    @And("retailer clicks on the Retailer Profile")
    public void retailerClicksOnTheRetailerProfile() {
//     @And("retailer clicks on the Retailer Profile{string}")
//     public void retailerClicksOnTheRetailerProfile(String text) {
//    driver.findElement(By.xpath("//div[@class='"+text+"']")).click();

       retryClick(driver.findElement(By.xpath("//a[text()='emmanueljThree']")));

    }

    @And("it redirect to the retailer profile screen")
    public void itRedirectToTheRetailerProfileScreen() throws InterruptedException, IOException {
        Thread.sleep(6000);
        driver.getCurrentUrl();
        String brandName = driver.findElement(By.xpath("(//div[@class='title'])[2]")).getText();
        log.info("RetailerName is: " + brandName);


    }

    @And("Retailer clicks on the Approve Button without assign any product")
    public void retailerClicksOnTheApproveButtonWithoutAssignAnyProduct() throws InterruptedException {

        driver.findElement(By.xpath("//button[normalize-space()='Approve']")).click();

    }

    @Then("it should display the error message {string}")
    public void itShouldDisplayTheErrorMessage(String message) throws InterruptedException {
        Thread.sleep(1500);
        String popup = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText();
        assertEquals(popup,message);
        log.info("The displayed error test is : " + popup);
    }
    @And("Brand click the Retailer profile {string}")
    public void brandClickTheRetailerProfile(String text) {
        driver.findElement(By.xpath("//a[text()='"+text+"']/parent::div/parent::div/parent::td")).click();
    }
    @When("Brand clicks on Decline button from Retailer Profile Screen")
    public void brandClicksOnDeclineButtonFromRetailerProfileScreen() throws InterruptedException {
Thread.sleep(3000);
        String brandName = driver.findElement(By.xpath("(//div[@class='title'])[2]")).getText();
        log.info("RetailerName is: " + brandName);
        if (driver.findElement(By.xpath("(//div[@class='title'])[2]")).getText().contains("Declined"))
            log.info("The profile " + brandName + " is already Declined");
        else
            Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Decline']")).click();
    }

        @Then("a confirmation message will display")
        public void aConfirmationMessageWillDisplay() {

        String declinepopup = driver.findElement(By.xpath("//div[@class='popup_content']")).getText().trim();
        log.info("The confirmation note is:" + declinepopup);
//        assertTrue(declinepopup.contains(DeclineError));
    }

    @When("Brand clicks on {string} from the pop-up")
    public void brandClicksOnFromThePopUp(String yes) {
        waituntilClickable(driver.findElement(By.xpath("//button[normalize-space()='Yes']")));
    }

    @Then("the brand-retailer connection request’s status is updated from {string} to {string}")
    public void the_brand_retailer_connection_request_s_status_is_updated_from_to(String string, String string2) throws InterruptedException {

        String pending = driver.findElement(By.xpath("//span[text()='Pending']")).getText();
        log.info("The Before Status is: " + pending);
        Thread.sleep(3000);
        String decline = driver.findElement(By.xpath("//span[@class='status-pill w-auto false pill_pending false']")).getText();
        log.info("The After Status is: " + decline);

    }

    @And("a success message is displayed on the screen: {string}")
    public void aSuccessMessageIsDisplayedOnTheScreen(String arg0) {
    }



    @Then("the Retailer Profile Screen is displayed with an option to Decline")
    public void theRetailerProfileScreenIsDisplayedWithAnOptionToDecline() {
        boolean displayed = driver.findElement(By.xpath("//button[normalize-space()='Decline']")).isDisplayed();
        log.info(displayed);
        String declineenabled = driver.findElement(By.xpath("//button[normalize-space()='Decline']")).getText();
        log.info("The button is: " + declineenabled);
    }
    @When("user clicks on Decline")
    public void userClicksOnDecline() {
        driver.findElement(By.xpath("//button[normalize-space()='Decline']")).click();
    }
        @Then("a pop-up message will displayed on the Screen")
        public void aPopUpMessageWillDisplayedOnTheScreen() {
            String declinerror = driver.findElement(By.xpath("//div[@class='popup_content']")).getText();
            log.info(declinerror);

        }


    @Then("the retailer connection status is updated from {string} to {string}")
    public void theRetailerConnectionStatusIsUpdatedFromTo(String arg0, String arg1) {
        String connect = driver.findElement(By.xpath("//span[@class='status-pill w-auto pill_connected false false']")).getText();
        log.info(connect);
    }

    @And("all previously assigned products are unassigned")
    public void allPreviouslyAssignedProductsAreUnassigned() throws IOException {
        screenShot("assignpro");
    }

    @And("a message is displayed on the screen: {string}")
    public void aMessageIsDisplayedOnTheScreen(String arg0) throws IOException {
        screenShot("Approved retailer declined the connected mess");
    }
//5
    @When("user clicks on View or Edit link from one of the Approved retailers")
    public void userClicksOnLinkFromOneOfTheApprovedRetailers() {

        driver.findElement(By.xpath("(//div[@class='dropdown_header'])[7]")).click();
        driver.findElement(By.xpath("(//a[text()='View/Edit'])[3]")).click();
    }

    @Then("the following screen will be display: {string}")
    public void theFollowingScreenWillBeDisplay(String text) {
        Assert.assertEquals(driver.findElement(By.xpath("//h3[text()='You currently have no requests for access from any retailer.']")).getText().trim(), text);

    }


    @And("Retailer clicks on the Approve Button with assigning one product")
    public void retailerClicksOnTheApproveButtonWithAssigningOneProduct() {
        driver.findElement(By.xpath("//button[@class='tab-link active']")).click();
        driver.findElement(By.xpath("(//input[@class='ant-checkbox-input'])[2]")).click();
        driver.findElement(By.xpath("//button[@class='button button button-red unassign-modal']")).click();


    }

}

