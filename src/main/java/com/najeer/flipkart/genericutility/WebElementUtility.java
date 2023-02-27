package com.najeer.flipkart.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is to override WebElements methods.
 * 
 * @author Admin
 *
 */
public class WebElementUtility {

	/**
	 * This method is used to wait for and element and click.
	 * 
	 * @author Najeer
	 * @param driver
	 * @param elementToClick
	 */
	public void clickOnElement(WebDriver driver, WebElement elementToClick) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(elementToClick));
		elementToClick.click();
	}

	/**
	 * This method is used to wait for and element and submit.
	 * 
	 * @author Najeer
	 * @param driver
	 * @param elementToSubmit
	 */
	public void submitAnElement(WebDriver driver, WebElement elementToSubmit) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(elementToSubmit));
		elementToSubmit.submit();
	}

	/**
	 * This method is used to wait for and element and send data.
	 * 
	 * @author Najeer
	 * @param driver
	 * @param elementToSendKeys
	 * @param keys
	 */
	public void sendKeysToElement(WebDriver driver, WebElement elementToSendKeys, String keys) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(elementToSendKeys));
		elementToSendKeys.clear();
		elementToSendKeys.sendKeys(keys);
	}
}