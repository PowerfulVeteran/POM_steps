package com.qa.temp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.temp.utils.Constants;
import com.qa.temp.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	//By Locators:
	
	private By username = By.cssSelector("input#input-email");
	private By password = By.cssSelector("input#input-password");
	private By loginButton = By.cssSelector("input[value='Login']");
	private By forgotPwdLink = By.xpath("//form //a [text()='Forgotten Password']");
	
	
	//Constructors:
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
	}
	
	
	//Page Action Methods:
	
	public String getLoginPageUrl() {
		return elementUtil.getPageUrl();
	}
	
	public String getLoginPageTitle() {
		return elementUtil.waitForTitle(5, Constants.TITLE_SERACH_TEXT);
	}
	
	public Boolean isForgotPasswordLinkAvailable () {
		return elementUtil.getElement(forgotPwdLink).isDisplayed();
	}
	
	public AccountsPage doLogin  (String un, String pwd) {
		elementUtil.getElement(username).sendKeys(un);
		elementUtil.getElement(password).sendKeys(pwd);
		elementUtil.getElement(loginButton).click();
		return new AccountsPage(driver);
	}
}

