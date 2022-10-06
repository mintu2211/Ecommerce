package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {


	WebDriver ldriver;

	public myAccount(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver , this);

	}



	//identify webelements create new user 
	@FindBy(id = "email_create")
	WebDriver CreateEmailId;

	@FindBy(name = "SubmitCreate")
	WebDriver SubmitCreate;
	
	


	// create webelements resgitered user
	@FindBy(id = "email")
	WebDriver registeredUserEmailId;

	@FindBy(id  = "passwd")
	WebDriver resgisteredUserPassword;

	@FindBy(id  = "SubmitLogin")
	WebDriver signIn;


  public void enteruserId(String email)
  {
	  registeredUserEmailId.sendkeys(email);
	  
  }

}
