package org.pojo;

import org.Base.BaseClase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class pojoSignupPage extends BaseClase {
	
	 public pojoSignupPage() {
		 PageFactory.initElements(driver, this);
			}
	
	 @FindBy (xpath = "//input[@placeholder='First name']")
	 private WebElement firstname;
	 
	 @FindBy (xpath = "//input[@placeholder='Last name']")
	 private WebElement lastname;

	 @FindBy (xpath = "//input[@placeholder='Email address']")
	 private WebElement emailaddress;
	 
	 @FindBy (xpath = "//input[@placeholder='Enter password']")
	 private WebElement enterpassword;
	 
	 public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getEmailaddress() {
		return emailaddress;
	}

	public WebElement getEnterpassword() {
		return enterpassword;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getHere() {
		return here;
	}

	public WebElement getSignupbutton() {
		return signupbutton;
	}

	@FindBy (xpath = "//div[@class='checkbox-text']")
	 private WebElement checkbox;
	 
//	 @FindBy (xpath = "//a[normalize-space()='Terms']")
//	 private WebElement terms;
//	 
//	 @FindBy (xpath = "//a[@href='https://shopdotapp.com/privacy-policy/']")
//	 private WebElement privacy;
	 
	 @FindBy(xpath = "//a[normalize-space()='here']")
	 private WebElement here;
	 
	 @FindBy (xpath = "//button[normalize-space()='Sign Up']")
	 private WebElement signupbutton;
	 
	 
}
