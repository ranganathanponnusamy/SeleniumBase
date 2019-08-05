package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.SearchResults;


public class Zoopla extends TestBase
{
	HomePage homepage;
	SearchResults searchpage;
	
	

	@Test(priority=1)
	public void TC_001() throws InterruptedException
	{
		homepage=new HomePage(driver);
		String homePageTitle=homepage.VerifyPageTitle();
		Assert.assertEquals(homePageTitle, "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents","Home page title not matched");
		homepage.EnterSearchText("London");
		homepage.ClickSubmit();
		searchpage=new SearchResults();
		String text=searchpage.verifyPageTitle();
		Assert.assertEquals(text, "Property for sale in London","Search Results page title not matched");
		searchpage.ClickSearchResultByName("Marketed by Barnard Marcus - Auctions");
		
		
		
	}
	

}
