package com.najeer.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.najeer.flipkart.genericutility.BaseClass;

public class FlipkartCartPage extends BaseClass {

	public FlipkartCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//button/span[text()='Place Order']")
	private WebElement placeOrderButton;
	
	@FindBy (xpath = "//span[text()='Price details']")
	private WebElement priceDetailsText;
	
	@FindBy (xpath = "//a[@class='_2Kn22P gBNbID']")
	private WebElement cartItem;
	
	public WebElement getCartItem() {
		return cartItem;
	}

	public WebElement getPriceDetailsText() {
		return priceDetailsText;
	}

	public WebElement getPlaceOrderButton() {
		return placeOrderButton;
	}

	public FlipkartCheckoutPage clickOnPlaceOrderButton() {
		webDriverUtils.waitForElementToBeClickable(driver, placeOrderButton);
		webElementUtils.clickOnElement(driver, placeOrderButton);
		return new FlipkartCheckoutPage(driver);
	}
}
