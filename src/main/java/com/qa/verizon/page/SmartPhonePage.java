package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.verizon.util.ElementUtil;
import com.qa.verizon.util.JavaScriptUtil;

public class SmartPhonePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	By phone=By.xpath("//a[@aria-label='Samsung Galaxy S20 5G UW']");
	
	public SmartPhonePage(WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		}
	
	public String getPageTitle(){
		//return driver.getTitle();
		return elementUtil.doGetPageTitle();
	}
	public String  getUrl(){
		//return driver.getCurrentUrl();
		return elementUtil.doGetPageUrl();
		
	}
	public PhonePage selectPhone(){
		
		JavaScriptUtil.scrollPageDown(driver);
		JavaScriptUtil.clickElementByJS(driver.findElement(phone), driver);
		
	return new PhonePage(driver);
		
	}

}


