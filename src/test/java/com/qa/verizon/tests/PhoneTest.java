	package com.qa.verizon.tests;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.PhonePage;
import com.qa.verizon.page.SmartPhonePage;
import com.qa.verizon.page.VerizonMainPage;

import com.qa.verizon.util.constants;

public class PhoneTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	VerizonMainPage mainPage;
	SmartPhonePage smartPhone;
	PhonePage phonePage;
	
	@BeforeMethod
	public void setUp(){
	basePage= new BasePage();
	prop=basePage.init_properties();
	String browserName=prop.getProperty("browser");
	driver=basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
	mainPage=new VerizonMainPage(driver);
	smartPhone=mainPage.clickSmartPhone();
	try {
		Thread.sleep(3000);
	} catch (Exception e) {
		// TODO: handle exception
	}
	phonePage=smartPhone.selectPhone();

	
	}
	@Test(priority = 1, description="Verify PreOrder Page title")
	public void getTitle() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		String title = phonePage.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, constants.PREORDER_PAGE_TITLE);
	}

	@Test(priority = 3, description="selected phone color size and price")
	public void selectPhoneFeature() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		phonePage.selectPhoneFeature();
		
	}
	@Test(priority = 2, description="verify page URL")
	public void verfyURL()  {
		String url = phonePage.getURL();
		System.out.println(url);
		Assert.assertEquals(url, constants.PREODER_PAGE_URL);
		}
	
	@Test(priority=4, description="handle zipcode section")
	public void handleZipCode() throws InterruptedException {
		
		phonePage.handleZipCode();
	}
	@Test(priority=5, description="click new customer section")
	public void handleCustomerType() throws InterruptedException {
		phonePage.handleCustomerType();
	}
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

	
	
	
}
