package com.mystore.testcases;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.mystore.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	ReadConfig readconfig=new ReadConfig();

	String url=readconfig.getBaseURL();
	String browser=readconfig.getBrowser();

	public static Logger logger;
	public static WebDriver driver;
	//browser hame sabhi test cases me chaiye 

	@BeforeClass
	public void setup()
	{
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;

		case"msedge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

		default:
			driver=null;
			break;
		}


		//imlicit wait for 10 sec
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//for logging
		logger =LogManager.getLogger("MyStoreV1");

	}



	public void capturescreenshot(WebDriver driver, String testname) throws IOException 
	{
		//step1: convert webdriver object to takescreenshot interface
		TakesScreenshot screenshot=((TakesScreenshot)driver);
		//Step 2: call get screenshotAS method to create image file

		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir") + "\\Screenshots\\" + testname + ".png");
		//File dest=new File("C:\\Users\\Devendra\\git\\Ecommerce\\MyStoreV1\\Screenshots\\FullPage.png");
		//step3: copy image file to destination
		FileUtils.copyFile(src, dest);
	}


	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
