package com.qa.temp.tests;

import java.util.Collections; 
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.temp.base.BaseTest;
import com.qa.temp.utils.Constants;
import com.qa.temp.utils.ErrorMsgs;



public class AccountsPageTest extends BaseTest {

	@BeforeClass //this annotation's priority is 3, therefore it will be invoked AFTER BaseTest's @BeforeTest annotation.
	public void accPageSetup () {
		accPage = loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@Test(priority = 0, enabled = true)
	public void accountPageTitleTest() {
		String title = accPage.getAccountPageTitle();
		System.out.println("Account Page Title is:"+title);
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE,ErrorMsgs.ACCOUNT_PAGE_TITLE_ERROR);
	}
	
	@Test
		public void accountPageLogoTest () {
		Assert.assertTrue(accPage.getAccountPageLogoHeader().isDisplayed());
	}
	
	@Test
		public void accountPageSectionsTest () {
		List <String> secList = accPage.getAccountPageSectionsList();
		secList.stream().forEach(e->System.out.println(e));
		Collections.sort(Constants.ACCOUNTS_PAGE_Expected_sectionList);
		Assert.assertEquals(secList, Constants.ACCOUNTS_PAGE_Expected_sectionList);
	}
	
	@Test
		public void accountPageLogoutLinkTest() {
		Assert.assertTrue(accPage. isAccountPageLogoutLinkDisplayed(), ErrorMsgs.ACCOUNT_PAGE_LOGOUT_LINK_ABSENT_ERROR);
	}
	
	@Test
		public void accountPageUrlTest () {
		Assert.assertTrue(accPage.getAccountPageUrl().contains(Constants.ACCOUNTS_PAGE_URL),ErrorMsgs.ACCOUTN_PAGE_URL_ERROR);
		
	}
	
	
	
}
