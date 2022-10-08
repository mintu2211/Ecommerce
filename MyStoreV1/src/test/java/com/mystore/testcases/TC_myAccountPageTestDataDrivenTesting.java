package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationdetals;
import com.mystore.pageobject.indexpage;
import com.mystore.utilities.ReadConfig;
import com.mystore.utilities.ReadExcelFile;

public class TC_myAccountPageTestDataDrivenTesting extends Baseclass {


	 ReadConfig readconfig=new ReadConfig();

	@Test(enabled = true)
	public void verifyregistrationAndLogin()
	{
     
		 ReadConfig readconfig=new ReadConfig();
		//launch browse
		//open url
		driver.get(url);
		logger.info("url open");


		indexpage pg=new indexpage(driver);
		pg.clickOnSignIn();
		logger.info("click on signIn");



		driver.findElement(By.id("email_create")).sendKeys("devendr.2211@gmail.com");
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


	@Test(dataProvider = "LoginDataProvider")
	public void verifylogin(String userName, String password, String expecteduserName) throws IOException 
	{
		//launch browse
		//open url
		driver.get(url);
		logger.info("url open");


		indexpage pg=new indexpage(driver);
		pg.clickOnSignIn();
		logger.info("click ion signIn");

		driver.findElement(By.id("email")).sendKeys(userName);
		logger.info("enter registered email");
		

		driver.findElement(By.id("passwd")).sendKeys(password);
		logger.info("enter registered password");
		driver.findElement(By.id("SubmitLogin")).click();
		logger.info("verifyLogin -Passed");
		capturescreenshot(driver, "verifylogin");
		
		
		}

	
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider() throws IOException
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName=System.getProperty("user.dir")+ "\\TestData\\MyStoreTestData.xlsx";
		//humne sare method static banaye hai isliye hume object create nahi karne pad raha hai
		int ttlRow=ReadExcelFile.getRowCount(fileName, "LoginTestdata");
		int ttlcolumn = ReadExcelFile.getColCount(fileName, "LoginTestdata");
		
		String data[][]=new String[ttlRow-1][ttlcolumn];
		
		for(int i=1; i<ttlRow; i++)//row=1,2
		{
			for(int j=0; j<ttlcolumn; j++)//col=0,1,2
			{
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginTestdata", i, j);
			}
		}
		return data;
		
	}


}
