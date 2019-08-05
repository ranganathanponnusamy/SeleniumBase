package com.qa.pages;
import org.openqa.selenium.By;


import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.*;
public class SearchResults extends TestBase{
	

	private By resulstPane=By.xpath("//*[@id='content']/ul/li");
	private By searchTitle = By.xpath("//*[@id='content']/div[1]/h1");
	public String text;

	public String verifyPageTitle()
	{
		//PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(searchTitle));
		text=element.getText();
		System.out.println(text);
		return text;
	}

	public void ClickSearchResultByName(String name)
	{
		
		
		List<WebElement> listdata= driver.findElements(resulstPane);
		for(int counter=0; counter<listdata.size();counter++)
		{
			String text=driver.findElement(By.xpath("//*[@id='content']/ul/li['"+counter+"']/div/div[2]/div[1]/img")).getAttribute("alt");
			if (text.equals("Marketed by Barnard Marcus - Auctions"))
					{
						driver.findElement(By.xpath("//*[@id='content']/ul/li['"+counter+"']/div/div[2]/a")).click();
						System.out.println("Clicked on the Ad");
						break;
					}
			
		}
		
	}
}
