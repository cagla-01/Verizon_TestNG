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

public class SmartPhoneTestPage {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	VerizonMainPage mainPage;
	SmartPhonePage smartPhone;
	
	@BeforeMethod
	public void setUp() throws IOException{
		basePage=new BasePage();
		prop=basePage.init_properties();
		String browserName=prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		
		mainPage=new VerizonMainPage(driver);
		smartPhone=mainPage.clickSmartPhone();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Test(priority=1, description="verify SmartPhonePage url")
	public void getURL(){
		String url=smartPhone.getUrl();
		System.out.println(url);
		Assert.assertTrue(true, url.concat(constants.SMARTPHONE_URL)); 
	}
	@Test(priority=2, description="verify SmartPhonePage title")
	public void getTitle(){
		String title=smartPhone.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, constants.SMARTPHONE_PAGE_TITLE);
		
	}
	@Test(priority=3, description="select a phone")
	public void selectPhone(){
		smartPhone.selectPhone();
		
		
	}
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}

}
