package org.Base;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.PropertiesReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.pojo.pojoSignInpage;

public class BaseClase {
    public static WebDriver driver;
    public pojoSignInpage pojoSignInpage;
    public Logger logger;

    public JavascriptExecutor jsExecutor;


    public BaseClase() {
        pojoSignInpage = new pojoSignInpage(driver);
        logger = LogManager.getLogger(BaseClase.class);
        jsExecutor = (JavascriptExecutor) driver;

    }

    public WebDriver launchBrowser(String browserName) throws Exception {


        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();

                options.addArguments("start-maximized");
                options.addArguments("test-type");
                options.addArguments("disable-notifications");
                options.addArguments ("autofill.profile_enabled");
                options.addArguments("--incognito");

                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Emman\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
                driver = new ChromeDriver(options);

            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().setSize(new Dimension(1920, 1080)); // Set your desired window size

            } else {
                throw new Exception("Browser Name is invalid");
            }

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            return driver;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return driver;

    }

    public static void windowMax() {
        driver.manage().window().maximize();


    }


    public static WebElement waitforElementVisiblity(WebElement element) {
        try {
//				
            WebDriverWait wb = new WebDriverWait(driver, 60);
            wb.until(ExpectedConditions.visibilityOf(element));
            return element;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return element;
    }

    public static WebElement

    waituntilClickable(WebElement element) {
        try {
//

            WebDriverWait wb = new WebDriverWait(driver, 60);
            wb.until(ExpectedConditions.elementToBeClickable(element)).click();
            ;


        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }
        return element;
    }

    public static void launchurl(String url) {
        try {
            driver.get(url);


            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public static void selectMultiplecheckBox(WebElement element) {
        try {
            String attribute = element.getAttribute("checked");
            System.out.println(attribute);
            if (attribute.equalsIgnoreCase("true")) {
                System.out.println("Element is already checked");
            } else {
                element.click();
            }
        } catch (Exception e) {
            System.out.println("Element needs to click");
            element.click();

}

    }
    public void retryClick(WebElement element) {
        try {
            element.click();
        } catch (StaleElementReferenceException e) {
            // Re-try the click operation
            retryClick(element);
        }
    }

    public static void mouseHoverToElement(WebElement element) {
        try {
            waitforElementVisiblity(element);
            Actions ac = new Actions(driver);
            ac.moveToElement(element).build().perform();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void pageTitle() {
        String title = driver.getTitle();
        System.out.println(title);
    }

    public static void pageUrl() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
    }

    public static void sendText(WebElement webElement, String text) {
        ((WebElement) webElement).sendKeys(text);
    }

    public static void closeEntireBrowser() {
        driver.quit();
    }

    public static void clickBtn(WebElement we) {
        we.click();
    }

    public static void closeWindow() {
        driver.close();
    }

    public static void navigateBack() {
        driver.navigate().back();
    }

    public static void navigateforward() {
        driver.navigate().forward();
    }

    public static void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public static void navigateRefresh() {
        driver.navigate().refresh();
    }

    public static void alertAccept() {
        driver.switchTo().alert().accept();
    }

    public static void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public static void alertGetText() {
        String gettext = driver.switchTo().alert().getText();
        System.out.println(gettext);
    }

    public static void alertSentKeys(String values) {
        driver.switchTo().alert().sendKeys(values);
    }

    public static void isEnable(WebElement element) {
        if (element.isEnabled()) {
            System.out.println(element.isEnabled());
        } else {
            System.out.println("False");
        }
    }

    public static void isDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            System.out.println(element.isDisplayed());
        } else {
            System.out.println("False");
        }
    }

    public static void isSelected(WebElement element) {
        if (element.isSelected()) {
            System.out.println(element.isSelected());
        } else {
            System.out.println("False");
        }
    }


    public static void screenShot(String imgName)  {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File des = new File("./ScreenShot/"+imgName+".png");
            FileUtils.copyFile(src, des);
        } catch (WebDriverException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void dropDown(WebElement element, String type, String value) {
        Select s = new Select(element);
        if (type.equalsIgnoreCase("selectbyvalue")) {
            s.selectByValue(value);
        } else if (type.equalsIgnoreCase("selectbyindex")) {
            int data = Integer.parseInt(value);
            s.selectByIndex(data);
        } else if (type.equalsIgnoreCase("selectbyvisibletext")) {
            s.selectByVisibleText(value);
        }
    }

    public static Actions a;

    public static void moveTheCursor(WebElement ele) {
        a = new Actions(driver);
        a.moveToElement(ele).perform();
    }

    public static void dragDrop(WebElement drag, WebElement drop) {
        a = new Actions(driver);
        a.dragAndDrop(drag, drop).perform();
    }

    public static JavascriptExecutor js;

    public static void scrollToTheElement(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void scroll(WebElement we) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false)", we);
    }

    public void Timewait() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public void typeText(String text, WebElement element) {
        logger.info("Entering Text:" + text);
        waitforElementVisiblity(element);
        logger.info("Clearing input field");
        element.clear();


        element.sendKeys(text);
    }

//	}
//		public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
//	        File f = new File("excellocation.xlsx");
//	        FileInputStream fis = new FileInputStream(f);
//	        Workbook wb = new XSSFWorkbook(fis);
//	        Sheet ms = wb.getSheet("Data");
//	        Row r = ms.getRow(rowNum);
//	        Cell c = r.getCell(cellNum);
//	        int cellType = c.getCellType();
//	        String value = " ";
//	        if (cellType==1) {
//				String value2 = c.getStringCellValue();
//			}
//	        else if (DateUtil.isCellDateFormatted(c)) {
//				Date dateCellValue = c.getDateCellValue();	
//				SimpleDateFormat sdf = new SimpleDateFormat(value);
//				String format = sdf.format(dateCellValue);
//				}
//	        else {
//	        	double d = c.getNumericCellValue();
//				long l = (long)d;
//			  String valueOf = String.valueOf(l);
//			}
//	       }
//		public static void createNewExcel(int rowNum, int CellNum, String newData) throws IOException {
//	        File f = new File("C:\\Users\Emman\\eclipse-workspace\\ShopDot\\Excel.xlsx");
//	        Workbook wb = new XSSFWorkbook();
//	        Sheet s = wb.createSheet("data");
//	        Row r = s.createRow(rowNum);
//	        Cell c = r.createCell(CellNum); 
//	        c.setCellValue(newData);
//	        FileOutputStream fos = new FileOutputStream(f);
//	        wb.write(fos);
//	        }
//		public static void createCell(int rowNum, int CellNum, String newData) throws IOException {
//	        File f = new File("C:\\Users\\Emman\\eclipse-workspace\\ShopDot\\Excel.xlsx");
//	        FileInputStream fis = new FileInputStream(f);
//	        Workbook wb = new XSSFWorkbook(fis);
//	        Sheet s = wb.getSheet("data");
//	        Row r = s.getRow(rowNum);
//	        Cell c = r.createCell(CellNum); 
//	        c.setCellValue(newData);
//	        FileOutputStream fos = new FileOutputStream(f);
//	        wb.write(fos);
//	        }
//		public static void createRow(int rowNum, int CellNum, String newData) throws IOException {
//	        File f = new File("C:\\Users\\magesh\\eclipse-workspace\\allFile\\Excel\\newFile.xlsx");
//	        FileInputStream fis = new FileInputStream(f);
//	        Workbook wb = new XSSFWorkbook(fis);
//	        Sheet s = wb.getSheet("data");
//	        Row r = s.createRow(rowNum);
//	        Cell c = r.createCell(CellNum); 
//	        c.setCellValue(newData);
//	        FileOutputStream fos = new FileOutputStream(f);
//	        wb.write(fos);
//	        }
    //}

    public void logInShopDot(String username, String password) {
        logger.info("Entering Username as:" + username);
        sendText(pojoSignInpage.getEmail(), username);
        logger.info("Entering Username as:" + password);
        sendText(pojoSignInpage.getPassword(), password);
        logger.info("Clicking on Log in button");
        clickBtn(pojoSignInpage.getLogin());
    }

    public static String generateRandomcharacter() {
        // Specify the characters allowed in the email address
        String allowedCharacters = "abcdefghijklmnopqrstuvwxyz0123456789_-,#$^&*.";

        int emailLength = 2;
        StringBuilder randomEmail = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < emailLength; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length());
            char randomChar = allowedCharacters.charAt(randomIndex);
            randomEmail.append(randomChar);
        }
        randomEmail.append("$");
        return randomEmail.toString();
    }

    // This method is used to give random integer
    public static int generateRandomNumber(int min, int max) {
        // Create a Random object
        Random random = new Random();

        // Generate a random number within the specified range [min, max]
        return random.nextInt(max - min + 1) + min;
    }

    public String getAbsolutePath(String relativePath) {
        return new File(relativePath).getAbsolutePath();
    }

    public static String generateRandom9DigitNumber() {
        Random random = new Random();
        // Generate a random number between 100,000,000 and 999,999,999
        long randomNumber = 100000000L + (long) (random.nextDouble() * 900000000L);
        return String.valueOf(randomNumber) ;
}
    public static String getRandomStringFromArray(String[] array) {
        Random random = new Random();
        int randomIndex = random.nextInt(array.length);
        return array[randomIndex];
}

}

