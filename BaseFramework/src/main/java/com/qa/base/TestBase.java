package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class TestBase 
{
	
	private final static String FilePath = System.getProperty("user.dir")+ "\\src\\main\\resources\\config.properties";
	public static String ChromePath=((System.getProperty("user.dir")+ "/src/main/resources/Drivers/chromedriver.exe"));
	static FileInputStream fs = null;

	public static Properties Config = null;

	String BrowserName;
	public static WebDriver driver;
	
	public static void fileSetup()
	{
		try 
		{
			fs = new FileInputStream(new File(FilePath));
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		Config = new Properties();
		try 
		{
			Config.load(fs);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void Setup() throws Exception
	{

		fileSetup();

		BrowserName = Config.getProperty("BrowserName");

		if (BrowserName.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");

			System.setProperty("webdriver.chrome.driver",ChromePath);
			driver = new ChromeDriver(options);

			Reporter.log(BrowserName + " Opened");
			driver.manage().window().maximize();
		}
		else if (BrowserName.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver");
			driver = new FirefoxDriver();
			Reporter.log(BrowserName + " Opened");		
			driver.manage().window().maximize();
			Reporter.log(BrowserName + " Maximized");

		}
		else if (BrowserName.equalsIgnoreCase("IE"))
		{
			driver = new InternetExplorerDriver();
			Reporter.log(BrowserName + " Opened");
		} 
		else 
		{
			Reporter.log(BrowserName + " is invalid");

			throw new Exception("Invalid Browser Name");
		}

		driver.get(Config.getProperty("Testing_URL"));
		Reporter.log(Config.getProperty("Testing_URL") + " Opened");
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("ImplicitWait")),	TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void TearDown() 
	{
		if (driver != null) 
		{
			driver.quit();
		}
	}
	
}
