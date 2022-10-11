package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationdetals;
import com.mystore.pageobject.indexpage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;
import com.mystore.utilities.ReadConfig;

public class TC_myAccountPageTest extends Baseclass {


	ReadConfig readconfig=new ReadConfig();

	@Test(enabled = false)
	public void verifyregistrationAndLogin() throws IOException
	{

		ReadConfig readconfig=new ReadConfig();
		//launch browse
		//open url
		driver.get(url);
		logger.info("url open");


		indexpage pg=new indexpage(driver);
		pg.clickOnSignIn();
		logger.info("click on signIn");



		driver.findElement(By.id("email_create")).sendKeys("devera.22@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();


		accountCreationdetals accountcreationPg=new accountCreationdetals(driver);

		accountcreationPg.selecttitleMrs();
		logger.info("select title");
		accountcreationPg.firstname("devendra");
		logger.info("enter Name");
		accountcreationPg.lastname("pandya");
		logger.info("enter Last Name");

		accountcreationPg.enterpassword("devendra11");
		accountcreationPg.addfirstname("devendra");
		accountcreationPg.addlastname("pandya");
		accountcreationPg.enteraddress("205 LBS Nagar");
		logger.info("enter Address");
		accountcreationPg.entercity("vidisha");
		logger.info("enter city");
		accountcreationPg.selectstate("Iowa");
		accountcreationPg.enterPostcode("00000");
		accountcreationPg.selectcountry("United States");
		accountcreationPg.entermoblino("9039140296");
		accountcreationPg.aliasAdd("200 link road no");
		accountcreationPg.clickOnRegister();
		registeredUserAccount reguser=new registeredUserAccount(driver);
		String userName=reguser.getUserName();
		Assert.assertEquals("devendra pandya", userName);

		capturescreenshot(driver, "verifyregistrationAndLogin");


	}


	@Test
	public void verifylogin() throws IOException 
	{
		//launch browse
		//open url
		driver.get(url);
		logger.info("url open");


		indexpage pg=new indexpage(driver);
		pg.clickOnSignIn();
		logger.info("click ion signIn");



		myAccount ma=new myAccount(driver);
		ma.enterEmail("devendra.vds2211@gmail.com");
		logger.info("enter registered email");
		ma.enterpassword("devendra11");
		logger.info("enter registered password");
		ma.clickOnSignIn();
		logger.info("verifyLogin -Passed");
		capturescreenshot(driver, "verifylogin");


		registeredUserAccount reguser=new registeredUserAccount(driver);
		String userName=reguser.getUserName();
		Assert.assertEquals("Devendra Pandya", userName);


	}



}
