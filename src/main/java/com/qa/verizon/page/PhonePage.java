package com.qa.verizon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.verizon.util.ElementUtil;
import com.qa.verizon.util.JavaScriptUtil;
import com.qa.verizon.util.constants;

public class PhonePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	By color = By.id("#FFC0CB");
	By size = By.id("128GB");
	By price = By.id("pricingOption0");
	By continueBtn = By.id("ATC-Btn");
	By zipcode = By.id("zipcode");
	By confirm = By.xpath("//button[@type='submit']");
	By newCustomer=By.xpath("//button[contains(text(),'New Customer')]");
	By cart=By.id("add-to-cart-modal-id");
	By xBy=By.xpath("//button[@type='submit']");
	
	
	public PhonePage(WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public void selectPhoneFeature() throws InterruptedException {
		JavaScriptUtil.specificScrollPageDown(driver);
		
//		elementUtil.doClick(color);
//		Thread.sleep(3000);
//		elementUtil.doClick(size);
//		Thread.sleep(3000);
//		elementUtil.doClick(price);
//		Thread.sleep(3000);
//		elementUtil.doClick(continueBtn);
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(color));
		actions.click(driver.findElement(size));
		actions.click(driver.findElement(price));
		actions.click(driver.findElement(continueBtn));
	}
	public String getURL() {
		return elementUtil.doGetPageUrl();
	}
	public String getTitle() {
		return elementUtil.doGetPageTitle();
	}
	public void handleZipCode() throws InterruptedException{
//		Thread.sleep(5000);
//		elementUtil.doClick(continueBtn);
//		Thread.sleep(5000);
//		elementUtil.doSendKeys(zipcode, constants.ZIPCODE);
//		Thread.sleep(5000);
//		elementUtil.doClick(confirm);
		
		elementUtil.waitForElementPresent(continueBtn);
		elementUtil.doClick(continueBtn);
		elementUtil.waitForElementPresent(zipcode);
		elementUtil.doSendKeys(zipcode, constants.ZIPCODE);
		elementUtil.waitForElementPresent(confirm);
		elementUtil.doClick(confirm);
	}
	
	public CartPage handleCustomerType() {
		PhonePage getMethod=new PhonePage(driver);
		try {
			getMethod.handleZipCode();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementUtil.doClick(newCustomer);
		
		return new CartPage(driver);
		
	}

}
