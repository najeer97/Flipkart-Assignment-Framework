package com.najeer.flipkart.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.najeer.flipkart.genericutility.BaseClass;
import com.najeer.flipkart.pages.FlipkartCartPage;
import com.najeer.flipkart.pages.FlipkartCheckoutPage;
import com.najeer.flipkart.pages.FlipkartHomePage;
import com.najeer.flipkart.pages.FlipkartSearchedItemPage;
import com.najeer.flipkart.pages.FlipkartSelectedItemPage;

public class EndToEndScenario extends BaseClass {
	FlipkartHomePage homePage;
	FlipkartSearchedItemPage searchedItemPage;
	FlipkartSelectedItemPage selectedItemPage;
	FlipkartCartPage cartPage;
	FlipkartCheckoutPage checkoutPage;
	
	@AfterMethod
	public void congigAfterMethod(ITestResult result) throws IOException {
		if (ITestResult.FAILURE==result.getStatus()) {
			webDriverUtils.takeScreenshots(driver, result.getMethod().getMethodName());
		}
	}
	
	@Test
	public void purchaseAnItem() throws IOException, InterruptedException, AWTException {
		homePage = new FlipkartHomePage(driver);
		//Close login popup
		homePage.closeLoginPopup();
		
		//Search ipad
		homePage.searchProduct(fileUtils.readPropertyFileData("itemToSearch"));
		webDriverUtils.waitForAllElementsInList(driver, homePage.getSuggestions());
		
		//select one option from suggestion
		searchedItemPage = homePage.selectFristSuggestion();
		Robot robot = new Robot();
		robot.mouseMove(0, 0);
		Thread.sleep(500);
		
		//apply the filter
		searchedItemPage.applyConnectivityFilterWifiOnly();
		
		//click on any product
		selectedItemPage = searchedItemPage.clickOnProduct();
		
		//capture the window id's
		Set<String> allWindowId = driver.getWindowHandles();
		String selectedItem = searchedItemPage.getAllProducts().get(0).getText();
		
		//swith the driver controll to selected item page
		for (String windowId : allWindowId) {
			driver.switchTo().window(windowId);
			if (driver.getTitle().contains(selectedItem)) {
				
				//verify the item
				Assert.assertEquals(selectedItem, selectedItemPage.getSelectedItem().getText());
				Reporter.log(selectedItem + " is selected successfully");
				
				//add item to cart
				selectedItemPage.clickOnAddToCart();
				cartPage = new FlipkartCartPage(driver);
				
				//place the order
				try {
					webDriverUtils.waitForPartialUrl(driver, "viewcart");
					
					//verify the item added to cart
					webDriverUtils.waitForElementVisibility(driver, cartPage.getCartItem());
					Assert.assertEquals(selectedItem, cartPage.getCartItem().getText());
					Reporter.log(selectedItem + " is added to cart successfully");
					checkoutPage = cartPage.clickOnPlaceOrderButton();
				} catch (Exception e) {
					cartPage = selectedItemPage.clickOnCartOption();
					
					//verify the item added to cart
					webDriverUtils.waitForElementVisibility(driver, cartPage.getCartItem());
					Assert.assertEquals(selectedItem, cartPage.getCartItem().getText());
					Reporter.log(selectedItem + " is added to cart successfully");
					checkoutPage = cartPage.clickOnPlaceOrderButton();
				}
				
				//enter email id and click on continue button
				checkoutPage.enterEmailId(fileUtils.readPropertyFileData("email"));
				
				//enter mobile number and click on continue button
				checkoutPage.enterMobileNumber(fileUtils.readPropertyFileData("mobile"));
			}else {
				
			}
		}
		
	}
}
