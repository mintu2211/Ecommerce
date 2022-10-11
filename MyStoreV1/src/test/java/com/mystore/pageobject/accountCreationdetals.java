package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreationdetals {

	WebDriver ldriver;

	public accountCreationdetals(WebDriver rdriver) 
	{

		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}

	//identify web elements
	@FindBy(id="id_gender2")
	WebElement titleMrs;

	@FindBy(id="customer_firstname")
	WebElement firstname;


	@FindBy(id="customer_lastname")
	WebElement lastname;


	@FindBy(id="email")
	WebElement email;

	@FindBy(id="passwd")
	WebElement password;
	
	
	
	@FindBy(id = "firstname")
	WebElement addfirstname;
	
	@FindBy(id = "lastname")
	WebElement addlastname;

	@FindBy(id="address1")
	WebElement address;

	@FindBy(id="city")
	WebElement city;

	@FindBy(id="uniform-id_state")
	WebElement state;

	@FindBy(id="postcode")
	WebElement postalcode;

	@FindBy(id="id_country")
	WebElement country;

	@FindBy(id="phone_mobile")
	WebElement mobile;

	@FindBy(id="alias")
	WebElement alias;

	@FindBy(id="submitAccount")
	WebElement submit;

	//action method for all web elements

	public void selecttitleMrs()
	{
		titleMrs.click();
	}

	public void firstname(String fname) {

		firstname.sendKeys(fname);
	}

	public void lastname(String lname) {
		lastname.sendKeys(lname);

	}

	public void enteremail(String emailAdd) {

		email.sendKeys(emailAdd);
	}

	public void enterpassword(String pwd) {

		password.sendKeys(pwd);
	}
	
	
	
	
	public void addfirstname(String afname)
	{
		addfirstname.sendKeys(afname);
		
	}
	
	public void addlastname(String alname)
	{
		addlastname.sendKeys(alname);
		
	}


	public void enteraddress(String add)
	{
		address.sendKeys(add);

	}

	public void entercity(String city1)
	{
		city.sendKeys(city1);
	}

	public void selectstate(int text1) {

		Select obj= new Select(state);
		obj.selectByIndex(text1);
		
	}


  public void enterPostcode(String postcode)
  {
	  postalcode.sendKeys(postcode);
  }

  public void selectcountry(String text) {
	  
	  Select obj1=new Select(country);
	  obj1.selectByVisibleText(text);
  }

  
  public  void entermoblino(String mobileno) {
	  
	  mobile.sendKeys(mobileno);
  }

  public void aliasAdd(String Aliasadd)
{
	  alias.sendKeys(Aliasadd);
}
  
  public void clickOnRegister()
  {
	  submit.click();
	  
  }
  
}