package com.qa.temp.tests;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.temp.utils.Constants;
import com.qa.temp.utils.ExcelUtil;
import com.qa.temp.base.BaseTest;


public class RegistrationPageTest extends BaseTest {
 
	@BeforeClass
	public void setupRegister () {
		registrationPage = loginpage.navigateToRegisterPage();
	}
	
	/*
	@Test
	// this was used before using ExcelUtil
	public void userRegistrationTest () {
		Assert.assertTrue(registrationPage.accountRegistration("Meet", "Patel", 
						"meetpate223@onermail.com", "232325689", "Meetp@123", "yes"));
	}
	*/
	@DataProvider
	public Object[] [] getRegisterData () {
		Object regData[] [] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return regData;
	}
	
	public String getRandomEmail () {
		Random randomGenerator = new Random();
		String email = "TestDataEmailId" + randomGenerator.nextInt(10000) + "@testmail.com";
		return email;
	}
	
		
	
	@Test (dataProvider = "getRegisterData")  //variable name's sequence same as in excel sheet 
	public void userRegistrationTest(String firstname, String lastname, 
									 String telephone, String password, String subscribe 	) {
		
		Assert.assertTrue(
				registrationPage.accountRegistration(firstname, lastname, 
													getRandomEmail(), telephone, 
													password, subscribe));
														
	}
	

}
