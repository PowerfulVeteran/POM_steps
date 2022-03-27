package com.qa.temp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.temp.base.BaseTest;
import com.qa.temp.utils.Constants;



public class LoginPageTest extends BaseTest {

	@Test(priority=1)
	public void loginPageTitleTest () {
		String title = loginpage.getLoginPageTitle();
		System.out.println("Loging page Title is:"+title);
		Assert.assertEquals(title, Constants.TITLE_SERACH_TEXT);
	}
	
	@Test(priority=2)
	public void loginPageUrlTest () {
		String url = loginpage.getLoginPageUrl();
		System.out.println("Loging page URL is:"+url);
		Assert.assertTrue(url.contains(Constants.URL_SEARCH_TEXT));
	}
	
	@Test(priority=3)
	public void loginPageForgotPwdLinkTest () {
		Assert.assertTrue(loginpage.isForgotPasswordLinkAvailable());
	}
	
	@Test(priority=4)
	public void loginPageLoginTest () {
		loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
}

