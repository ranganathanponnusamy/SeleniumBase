package com.qa.util;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;




public class SeleniumWebDriver {

	public static WebDriver driver;
	static WebDriverWait wait;
	public static Properties prop= new Properties();
	public static String ChromePath=((System.getProperty("user.dir")+ "/src/main/resources/Drivers/chromedriver.exe"));

	
	public WebDriver getDriver() {
		
		String broserName=prop.getProperty("browser");
		
		if(broserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ChromePath);	
			driver = new ChromeDriver(); 
		}
		return driver;
	}
	
	public String getTextValue(By element)
	{
		
		String text="";
		try 
		{
			text=driver.findElement(element).getAttribute("value").toString();
			System.out.println("Attribute Value:"+text);	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return text;
	}
	
	public static boolean sendKeys(By elementLocator, String value) 
	{
		
		 boolean result=false;
		try 
		{
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(elementLocator).clear();
			driver.findElement(elementLocator).sendKeys(value);
			
		}
		catch (Exception e) 
		{
		
			result = false;
			
		}
		return result;
	
	}
	public static boolean isElementPresent(By element)
	{
		boolean exists = true;
		try 
		{
			exists = driver.findElement(element).isDisplayed();			
		} catch (Exception e) 
		{		
			exists = false;
		}	
		
		return exists;
	}	
}
