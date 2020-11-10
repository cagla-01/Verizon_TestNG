package com.qa.verizon.page;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class VerizonMainPage {

	WebDriver driver;
	Actions actions;
	By shop=By.xpath("//button[@id='gnav20-Shop-L1']");
	By smartPhones=By.xpath("//a[@id='gnav20-Shop-L3-1']");
	
	
	public VerizonMainPage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	public void navigateShop(){
		
		actions=new Actions(driver);
		actions.moveToElement(driver.findElement(shop));
	}
	public SmartPhonePage clickSmartPhone(){
		WebElement goShop=driver.findElement(shop);
		actions=new Actions(driver);
		actions.moveToElement(goShop);
		WebElement smartPhoneBtn=driver.findElement(smartPhones);
		actions.click(smartPhoneBtn).build().perform();

		return new SmartPhonePage(driver);
	}
	
}
