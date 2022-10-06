package com.mystore.pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexpage {


	WebDriver ldriver;
	public indexpage(WebDriver rdriver)
	{

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}


	@FindBy(linkText = "Sign in")
	WebElement signIn;


	public void clickOnSignIn() {
		signIn.click();

	}

}
