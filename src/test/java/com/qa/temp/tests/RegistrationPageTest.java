package com.qa.temp.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.temp.base.BaseTest;


public class RegistrationPageTest extends BaseTest {
 
	@BeforeClass
	public void setupRegister () {
		registrationPage = loginpage.navigateToRegisterPage();
	}
	
	@Test
	// this was used before using ExcelUtil
	public void userRegistrationTest () {
		Assert.assertTrue(registrationPage.accountRegistration("Meet", "Patel", 
						"meetpate223@onermail.com", "232325689", "Meetp@123", "yes"));
	}
	

}
