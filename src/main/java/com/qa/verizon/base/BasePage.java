package com.qa.verizon.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage {
	WebDriver driver;
	Properties prop;
	public static String flash;
	
	public WebDriver init_driver(String browserName){
		
		System.out.println("browser name is: "+ browserName);
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
			}
		else if (browserName.equals("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver=new SafariDriver();
		}
		else{
			System.out.println("browser name "+ browserName + "is not found");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		return driver;
	}
	public Properties init_properties() {
		prop=new Properties();
		
		String path="./src/main/java/com/qa/verizon/config/config.properties";
		
		try {
			FileInputStream ip= new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("some issue with config properties... Please correct it");
		}catch(IOException e){
			e.printStackTrace();
		}
		return prop;
		
	}
	
	public void quitBrowser(){
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("some exception occured while quitting the browser");
		}
		
	}
  public void driverClose(){
	  try {
		driver.close();
	} catch (Exception e) {
		System.out.println("some exception occured while closing the browser");
	}
  }
}
