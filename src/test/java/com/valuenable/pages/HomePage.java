package com.valuenable.pages;

import static com.valuenable.constants.Browser.*;

import org.openqa.selenium.By;

import com.valuenable.constants.Browser;
import com.valuenable.constants.PartnerType;
import com.valuenable.utility.BrowserUtility;

public class HomePage extends BrowserUtility {

	public HomePage(Browser browser) {
		super(CHROME);
		goToWebSite("https://valuenable.in/");
	}

	private static final By GET_IN_TOUCH_BTN_LOCATOR = By.xpath("//div[contains(text(),'Get in Touch')]");
	private static final By FIRST_NAME_TEXTBOX_LOCATOR = By.id("First-Name-3");
	private static final By LAST_NAME_TEXTBOX_LOCATOR = By.id("Last-Name-3");
	private static final By EMAIL_TEXTBOX_LOCATOR = By.id("Email-4");
	private static final By PHONE_NO_TEXTBOX_LOCATOR = By.id("Phone-2");
	private static final By PARTNER_TYPE_DD_LOCATOR = By.id("Partner-Type");
	private static final By SOLUTION_DD_LOCATOR = By.id("Interested-In");
	private static final By MESSAGE_TEXTBOX_LOCATOR = By.id("field-2");
	private static final By SUMBIT_BUTTON_LOCATOR = By.xpath("//input[@type='submit']");
	private static final By CONFIRMATION_TEXT_LOCATOR = By.xpath("//div[contains(@class,'success-message-2')]//div");

	public HomePage clickOnGetInToch() {
		clickOn(GET_IN_TOUCH_BTN_LOCATOR);
		return this;
	}

	public HomePage enterFirstName(String firstName) {
		enterText(FIRST_NAME_TEXTBOX_LOCATOR, firstName);
		return this;
	}

	public HomePage enterLastName(String lastName) {
		enterText(LAST_NAME_TEXTBOX_LOCATOR, lastName);
		return this;
	}

	public HomePage enterEmail(String email) {
		enterText(EMAIL_TEXTBOX_LOCATOR, email);
		return this;
	}

	public HomePage enterPhone(String phoneNo) {
		enterText(PHONE_NO_TEXTBOX_LOCATOR, phoneNo);
		return this;
	}

	public HomePage selectPartnerType(PartnerType type) {
		selectbyVisibleText(PARTNER_TYPE_DD_LOCATOR, type);
		return this;
	}

	public HomePage selectSolution(String solution) {
		selectbyVisibleText(SOLUTION_DD_LOCATOR, solution);
		return this;
	}

	public HomePage sendMessage(String message) {
		enterText(MESSAGE_TEXTBOX_LOCATOR, message);
		return this;
	}

	public HomePage clickOnTalkToOurTeamButton() {
		clickOn(SUMBIT_BUTTON_LOCATOR);
		return this;
	}

	public String getConfirmationMessage() {
		return getVisibleText(CONFIRMATION_TEXT_LOCATOR);
	}

	public String getEmailValidationMessage() {
		return getWebElement(EMAIL_TEXTBOX_LOCATOR).getAttribute("validationMessage");
		
	}

}
