package com.valuenable.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.valuenable.constants.Browser;
import com.valuenable.pages.HomePage;

public class BaseTest {

	public HomePage homePage;

	@BeforeMethod
	public void setUp() {
		homePage = new HomePage(Browser.CHROME);
	}

	@AfterMethod
	public void quite() {
		homePage.quite();
	}

}
