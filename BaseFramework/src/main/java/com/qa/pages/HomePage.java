package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.PageFactory;


import com.qa.base.TestBase;

public class HomePage extends TestBase
{

	
	private By searchBox=By.id("search-input-location");
	private By submitBtn= By.id("search-submit");
			

	public HomePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyPageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	
	public Boolean EnterSearchText(String text) throws InterruptedException
	{
		Boolean status=false;		
		driver.findElement(searchBox).sendKeys(text);
		
		Thread.sleep(4000);
		List<WebElement> dataList=driver.findElements(By.xpath("//*[@id=\"bhome\"]/ul/li"));
		for( WebElement element:dataList)
		{
			String name=element.getText();
			if(name.equals("London"));
			{
				element.click();
				status=true;
				break;
			}
		}
		return status;
		
	}
	
	public void ClickSubmit() throws InterruptedException 
	{				driver.findElement(submitBtn).click();
		Thread.sleep(5000);	
		
	
	}
}

