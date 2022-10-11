package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class myAccount {


	WebDriver ldriver;

	public myAccount(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver , this);

	}



	//identify webelements create new user 
	@FindBy(id = "email_create")
	WebElement CreateEmailId;

	@FindBy(name = "SubmitCreate")
	WebElement SubmitCreate;
	
	
	public void createemail(String cemail) {
		
		CreateEmailId.sendKeys(cemail);
			
		}

	public void clicksubmit() {
		
		 SubmitCreate.click();
			
		}
	
	


	// create webelements resgitered user
	@FindBy(id = "email")
	WebElement registeredUserEmailId;

	@FindBy(id  = "passwd")
	WebElement resgisteredUserPassword;

	@FindBy(id  = "SubmitLogin")
	WebElement signIn;

	
	public void enterEmail(String remail) {
		
	  registeredUserEmailId.sendKeys(remail);
		
	}
	
	public void enterpassword(String rpwd) {
		
		  resgisteredUserPassword.sendKeys(rpwd);
			
		}

	public void clickOnSignIn() {
		
		 signIn.click();;
			
		}
  

}
