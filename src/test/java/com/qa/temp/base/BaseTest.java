package com.qa.temp.base;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.temp.factory.DriverFactory;
import com.qa.temp.pages.AccountsPage;
import com.qa.temp.pages.LoginPage;
import com.qa.temp.pages.ProductInfoPage;
import com.qa.temp.pages.RegistrationPage;
import com.qa.temp.pages.SearchResultPage;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage loginpage;
	public AccountsPage accPage;
	public SearchResultPage searchResPg;
	public ProductInfoPage productInfoPage;
	public RegistrationPage registrationPage;
	public Properties prop;
	DriverFactory df;
	
	/*
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.inti_driver(prop);
		loginpage = new LoginPage(driver);
	}
	*/
	
	@Parameters ({"browser"})
	@BeforeTest
		public void setUp(String browserName) {
		df = new DriverFactory();
		prop = df.init_prop();
		prop.setProperty("browser", browserName);
		driver = df.inti_driver(prop);
		loginpage = new LoginPage(driver);
	}
	
	
	@AfterTest
	public void tearDown () {
		driver.quit();
	}
	
}