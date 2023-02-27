package com.najeer.flipkart.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
public WebDriver driver;
public FileUtility fileUtils = new FileUtility();
public ExcelUtility excelUtils = new ExcelUtility();
public JavaUtility javaUtils = new JavaUtility();
public WebDriverUtility webDriverUtils = new WebDriverUtility();
public WebElementUtility webElementUtils = new WebElementUtility();

@BeforeClass
public void configBeforeClass() throws IOException {
	//Launch the browser
	
	String browserName = fileUtils.readPropertyFileData("browser");
	if (browserName.equals("chrome")) {
		driver = new ChromeDriver();
	}else if (browserName.equals("firefox")) {
		driver = new FirefoxDriver();	
	}else if (browserName.equals("edge")) {
		driver = new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	//Trigger the url
	driver.get(fileUtils.readPropertyFileData("url"));
}

@AfterClass
public void configAfterClass() throws IOException {
	//Terminate the current session
	driver.manage().window().minimize();
	driver.quit();
}
	
}
