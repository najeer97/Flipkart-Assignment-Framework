package com.najeer.flipkart.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used to get the data from WebDriver methods
 * @author Najeer
 *
 */

public class WebDriverUtility {
	
/**
 * This method is used to provide wait for findElement() and findElements()
 * @author Najeer
 * @param driver
 */

	public void implicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
/**
 * This method is used to provide explicitWait to the title get loaded by comparing complete title.
 * @author Najeer
 * @param driver
 * @param completeTitle
 * @return boolean
 */
	
	public boolean waitForCompleteTitle(WebDriver driver, String completeTitle) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.titleIs(completeTitle));
	}
	
/**
 * This method is used to provide explicitWait to the url get loaded by comparing complete url.
 * @author Najeer
 * @param driver
 * @param completeUrl
 * @return boolean
 */
	public boolean waitForCompleteUrl(WebDriver driver, String completeUrl) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.urlToBe(completeUrl));
	}
	
/**
 * This method is used to provide explicitWait to the title get loaded by comparing partial title.
 * @author Najeer
 * @param driver
 * @param partialTitle
 * @return boolean
 */
	public boolean waitForPartialTitle(WebDriver driver, String partialTitle) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.titleContains(partialTitle));
	}
	
/**
 * This method is used to provide explicitWait to the title get loaded by comparing partial title.
 * @author Najeer
 * @param driver
 * @param partialUrl
 * @return
 */
	public boolean waitForPartialUrl(WebDriver driver, String partialUrl) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.urlContains(partialUrl));
	}
	
/**
 * This method is used to provide explicitWait to the element till it get visible.
 * @author Najeer
 * @param driver
 * @param elementToWait
 */
	public void waitForElementVisibility(WebDriver driver, WebElement elementToWait) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(elementToWait));
	}

/**
 * This method is used to provide explicitWait to the element till it will be Clickable.
 * @author Najeer
 * @param driver
 * @param elementToClick
 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement elementToClick) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
	}
	
	public void waitForAllElementsInList(WebDriver driver, List<WebElement> elements) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
/**
 * This method is used to switch the driver control to the frame by using index value
 * @author Najeer
 * @param driver
 * @param index
 */
	
	public void switchToFrameWithIndex(WebDriver driver, int index) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}
	
/**
 * This method is used to switch the driver control to the frame by using Id or Name attribute value
 * @author Najeer
 * @param driver
 * @param idOrName
 */
	
	public void switchToFrameWithIdOrName(WebDriver driver, String idOrName) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
	}
	
/**
 * This method is used to switch the driver control to the frame by using frameElement reference
 * @author Najeer
 * @param driver
 * @param frameElement
 */
	
	public void switchToFrameWithWebElement(WebDriver driver, WebElement frameElement) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	
/**
 * This method is used to take the screenshots
 * @author Najeer
 * @param driver
 * @param methodName
 * @throws IOException
 */
	public void takeScreenshots(WebDriver driver,String methodName) throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile= new File("./errorshots/"+methodName+"_"+LocalDateTime.now().toString().replace(':', '-')+".png");
		FileUtils.copyFile(srcFile, destFile);
	}
}
