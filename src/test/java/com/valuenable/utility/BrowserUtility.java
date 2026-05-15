package com.valuenable.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.valuenable.constants.Browser;
import com.valuenable.constants.PartnerType;

public abstract class BrowserUtility {

	private WebDriver driver;
	WebDriverWait wait;
	Select select;

	public BrowserUtility(Browser browser) {
		if (browser == Browser.CHROME) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		} else if (browser == Browser.FIREFOX) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--start-maximized");
			driver = new FirefoxDriver(options);
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		}
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public void goToWebSite(String url) {
		driver.get(url);
	}

	public void clickOn(By Locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
		element.click();
	}

	public void enterText(By locator, String enterText) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(enterText);
	}

	public void selectbyVisibleText(By locator, PartnerType type) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		select = new Select(element);
		select.selectByVisibleText(type.toString());

	}

	public void selectbyVisibleText(By locator, String solution) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		select = new Select(element);
		select.selectByVisibleText(solution);

	}

	public String getVisibleText(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.getText();

	}

	public WebElement getWebElement(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;

	}

	public void quite() {

		this.driver.quit();
	}

}
