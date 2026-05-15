package com.valueable.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.valueable.pages.HomePage;
import com.valueanable.constants.Browser;

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
