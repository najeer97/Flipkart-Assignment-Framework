package com.najeer.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.najeer.flipkart.genericutility.BaseClass;

public class FlipkartSelectedItemPage extends BaseClass {

	public FlipkartSelectedItemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//button[text()='Add to cart']")
	private WebElement addToCartButton;
	
	@FindBy (className = "_3SkBxJ")
	private WebElement cartOption;
	
	@FindBy (className = "B_NuCI")
	private WebElement selectedItem;

	public WebElement getSelectedItem() {
		return selectedItem;
	}

	public WebElement getCartOption() {
		return cartOption;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}
	
	public void clickOnAddToCart() {
		webElementUtils.clickOnElement(driver, addToCartButton);
	}
	
	public FlipkartCartPage clickOnCartOption () {
		webElementUtils.clickOnElement(driver, cartOption);
		return new FlipkartCartPage(driver);
	}
}
