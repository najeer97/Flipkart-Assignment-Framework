package com.najeer.flipkart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.najeer.flipkart.genericutility.BaseClass;

public class FlipkartHomePage extends BaseClass{

	public FlipkartHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//All required elements
	@FindBy (css = "button[class='_2KpZ6l _2doB4z']")
	private WebElement loginPopupCloseButton;
	
	@FindBy (name = "q")
	private WebElement searchTextField;
	
	@FindBy (className = "_3izBDY")
	private List<WebElement> suggestions;
	
	public WebElement getLoginPopupCloseButton() {
		return loginPopupCloseButton;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public List<WebElement> getSuggestions() {
		return suggestions;
	}

	//All required actions
	
	public void closeLoginPopup() {
		webElementUtils.clickOnElement(driver, loginPopupCloseButton);
	}
	
	public void searchProduct(String itemToSearch) {
		webElementUtils.sendKeysToElement(driver, searchTextField, itemToSearch);
	}
	
	public FlipkartSearchedItemPage selectFristSuggestion() {
		webElementUtils.clickOnElement(driver, suggestions.get(0));
		return new FlipkartSearchedItemPage(driver);
	}
	
}
