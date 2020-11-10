package com.qa.verizon.tests;


import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.page.CartPage;
import com.qa.verizon.page.PhonePage;

import com.qa.verizon.page.SmartPhonePage;
import com.qa.verizon.page.VerizonMainPage;

public class CartPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	VerizonMainPage mainPage;
	SmartPhonePage smartPhone;
	
	PhonePage phonePage;
	CartPage cart;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		basePage=new BasePage();
		prop=basePage.init_properties();
		String browserName=prop.getProperty("browser");
		 driver=basePage.init_driver(browserName);
		 driver.get(prop.getProperty("url"));
		 mainPage=new VerizonMainPage(driver);
		 smartPhone=mainPage.clickSmartPhone();
		 try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		 phonePage=smartPhone.selectPhone();
		
		cart=phonePage.handleCustomerType();
		
		
	}
	@Test(priority=2, description="verify selected phone")
	public void verfySelectedPhone(){
		
		cart.verifySelectedPhone();
	
	}
	
	@Test(priority=1, description="verify URL")
	public void verifyURL() throws InterruptedException{
		cart.verifyURL();
		
	}
	
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}
	

}
