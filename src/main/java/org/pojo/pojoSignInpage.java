package org.pojo;

import org.Base.BaseClase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pojoSignInpage {

	public WebDriver getDriver() {
		return driver;
	}
	private WebDriver driver;
	 public pojoSignInpage(WebDriver driver) {
		 this.driver=driver;
	 PageFactory.initElements(driver, this);
		}
	@FindBy (name = "email")
	private WebElement email;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = "//a[normalize-space()='Forgot Password']")
	private WebElement forgotpass;
	
	@FindBy(xpath = "//button[normalize-space()='Log in']")
	private WebElement login;

//	Getters to access web elements outside the class
	
	
	public WebElement getForgotpass() {
		return forgotpass;
	}

	public void setForgotpass(WebElement forgotpass) {
		this.forgotpass = forgotpass;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

}
