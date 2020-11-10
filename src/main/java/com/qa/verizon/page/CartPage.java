package com.qa.verizon.page;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.verizon.util.ElementUtil;

import com.qa.verizon.util.constants;

public class CartPage {
	WebDriver driver;
	ElementUtil elementUtil;
	WebDriverWait wait;

	By cartBtn = By.xpath("//div[@class='gnav20-unifiedcart']//button[@aria-expanded='false']");
	By mobileSltion = By.xpath("//a[contains(text(),'Mobile solutions')]");
	By selectedPhone = By.xpath("//span[contains(text(),'Galaxy S20 5G UW')]");
	

	public CartPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		wait=new WebDriverWait(driver, 20);

	}

	public void verifySelectedPhone()  {
		elementUtil.doClick(cartBtn);
		elementUtil.doClick(mobileSltion);
		String text = driver.findElement(selectedPhone).getText();
		System.out.println(text);

		Assert.assertTrue(true, constants.SELECTED_PHONE);
	}

	public String verifyURL() throws InterruptedException {
		elementUtil.doClick(cartBtn);
		elementUtil.doClick(mobileSltion);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(true, constants.ADDCART_PAGE_URL);
		return url;
	}

}
