package com.mystore.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.mystore.pageobject.accountCreationdetals;
import com.mystore.pageobject.indexpage;

public class TC_myAccountPageTest extends Baseclass {



    
	@Test(priority = 1)
	public void verifyregistrationAndLogin()
	{

		//launch browse
		//open url
		driver.get(url);
		logger.info("url open");


		indexpage pg=new indexpage(driver);
		pg.clickOnSignIn();
		logger.info("click ion signIn");



		driver.findElement(By.id("email_create")).sendKeys("devendr.vds2211@gmail.com");
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
		accountcreationPg.enterPostcode("0000");
		accountcreationPg.selectcountry("United States");
		accountcreationPg.entermoblino("9039140296");
		accountcreationPg.aliasAdd("200 link road no 1vidisha");
		accountcreationPg.clickOnRegister();



	}


	@Test(priority = 2)
	public void verifylogin() 
	{
		//launch browse
		//open url
		driver.get(url);
		logger.info("url open");


		indexpage pg=new indexpage(driver);
		pg.clickOnSignIn();
		logger.info("click ion signIn");

		driver.findElement(By.id("email")).sendKeys("devendra.vds2211@gmail.com");
		logger.info("enter registered email");
		driver.findElement(By.id("passwd")).sendKeys("devendra11");
		logger.info("enter registered password");
		driver.findElement(By.id("SubmitLogin")).click();
		logger.info("subbmit");

		driver.quit();
		
		
	}



}
