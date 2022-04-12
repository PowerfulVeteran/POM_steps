package com.qa.temp.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {

	public static final String URL_SEARCH_TEXT = "account/login";
	public static final String TITLE_SERACH_TEXT = "Account Login";
	public static final String ACCOUNTS_PAGE_URL = "account/account";
	public static final String ACCOUNTS_PAGE_TITLE = "My Account";
	public static List<String> ACCOUNTS_PAGE_Expected_sectionList = Arrays
			.asList("My Account",
					"My Orders",
					"My Affiliate Account",
					"Newsletter");
	public static final String REGISTRATION_SUCCESS = "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME =  "nayu_TestData";
}
