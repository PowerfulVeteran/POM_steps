package com.qa.temp.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.temp.factory.DriverFactory;
import com.qa.temp.pages.LoginPage;

public class BaseTest {
	
	private WebDriver driver;
	public LoginPage loginpage;
	
	DriverFactory df;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		driver = df.inti_driver("firefox");
		loginpage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown () {
		driver.quit();
	}
	
	
	

}