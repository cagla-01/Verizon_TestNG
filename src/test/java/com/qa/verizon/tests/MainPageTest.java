package com.qa.verizon.tests;

import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.SmartPhonePage;
import com.qa.verizon.page.VerizonMainPage;
import com.qa.verizon.util.constants;

public class MainPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	VerizonMainPage mainPage;
	
	@BeforeMethod
	public void setUp() throws IOException{
		basePage=new BasePage();
		prop=basePage.init_properties();
		String browserName=prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		mainPage=new VerizonMainPage(driver);
		
	}
	
	@Test(priority=1, description="verify main page title")
	public void getPageTitle(){
		String title=mainPage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, constants.MAIN_PAGE_TITLE);
	}
	
	@Test(priority=2, description="navigate shop button")
	public void goShop(){
		mainPage.navigateShop();
	}
	
	@Test(priority=3, description="click smart phone button")
	public void clickSmartPhones() {
		mainPage.clickSmartPhone();
		
	}
	
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}

}
