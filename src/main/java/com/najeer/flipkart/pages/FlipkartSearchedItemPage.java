package com.najeer.flipkart.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.najeer.flipkart.genericutility.BaseClass;

public class FlipkartSearchedItemPage extends BaseClass {

	public FlipkartSearchedItemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "_4rR01T")
	private List<WebElement> allProducts;

	@FindBy(xpath = "//div[text()='Connectivity']")
	private WebElement connectivityFilterOption;

	@FindBy(xpath = "//div[text()='Wi-Fi Only']/../div[@class='_24_Dny']")
	private WebElement wifiOnlyOption;
	
	@FindBy (xpath = "//div[text()='Availability']")
	private WebElement availabilityFilterOption;
	
	@FindBy (xpath = "//div[text()='Exclude Out of Stock']/../div[@class='_24_Dny']")
	private WebElement excludeOutOfStockCheckbox;
	
	public WebElement getAvailabilityFilterOption() {
		return availabilityFilterOption;
	}

	public WebElement getExcludeOutOfStockCheckbox() {
		return excludeOutOfStockCheckbox;
	}

	public List<WebElement> getAllProducts() {
		return allProducts;
	}

	public WebElement getConnectivityFilterOption() {
		return connectivityFilterOption;
	}

	public WebElement getWifiOnlyOption() {
		return wifiOnlyOption;
	}

	public void applyConnectivityFilterWifiOnly() throws InterruptedException {
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 400).pause(1000).build().perform();
		webElementUtils.clickOnElement(driver, connectivityFilterOption);
		webElementUtils.clickOnElement(driver, wifiOnlyOption);
	}

	public FlipkartSelectedItemPage clickOnProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions
				.stalenessOf(allProducts.get(0))));
		webElementUtils.clickOnElement(driver, allProducts.get(0));
		return new FlipkartSelectedItemPage(driver);
	}
}
