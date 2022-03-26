package com.qa.temp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//By Locators:
	
	private By username = By.cssSelector("input#input-email");
	private By password = By.cssSelector("input#input-password");
	private By loginButton = By.cssSelector("input[value='Login']");
	private By forgotPwdLink = By.xpath("//form //a [text()='Forgotten Password']");
	
	
	//Constructors:
	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}
	
	
	//Page Action Methods:
	
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Boolean isForgotPasswordLinkAvailable () {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void doLogin  (String un, String pwd) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
	}
}

