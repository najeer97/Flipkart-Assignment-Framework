package com.najeer.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.najeer.flipkart.genericutility.BaseClass;

public class FlipkartCheckoutPage extends BaseClass {

	public FlipkartCheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@maxlength='auto']")
	private WebElement enterEmailMobileNumberTextField;

	@FindBy(xpath = "//button/span[text()='CONTINUE']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@maxlength='10']")
	private WebElement enterMobileNumberTextField;

	public WebElement getEnterEmailMobileNumberTextField() {
		return enterEmailMobileNumberTextField;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getEnterMobileNumberTextField() {
		return enterMobileNumberTextField;
	}

	public void enterEmailId(String email) {
		webElementUtils.sendKeysToElement(driver, enterEmailMobileNumberTextField, email);
		webElementUtils.clickOnElement(driver, continueButton);
	}

	public void enterMobileNumber(String mobile) {
		webElementUtils.sendKeysToElement(driver, enterMobileNumberTextField, mobile);
		webElementUtils.clickOnElement(driver, continueButton);
	}

}
