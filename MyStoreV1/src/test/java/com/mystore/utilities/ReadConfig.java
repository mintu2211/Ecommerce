package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	String path="C:\\Users\\Devendra\\git\\Ecommerce\\MyStoreV1\\Configuration\\config.properties";
	
	//create constructor
	//constructor
	public ReadConfig()
	{
		properties=new Properties();
		
			try {
				FileInputStream fis =new FileInputStream(path);
			  properties.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	public String getBrowser()
	{
		String brows =properties.getProperty("browser");
		if(brows!=null)
		return brows;
		else
			throw new RuntimeException("browser not specified");
		
	}
	
	public String getBaseURL()
	{
		String value =properties.getProperty("baseurl");
		if(value!=null)
		return value;
		else
			throw new RuntimeException("url not specified");
		
	}
	
	public String getEmail()
	{
		String emailadd =properties.getProperty("email");
		if(emailadd!=null)
		return emailadd;
		else
			throw new RuntimeException("email not specified");
		
	}
	public String getpassword()
	{
		String enterpass =properties.getProperty("password");
		if(enterpass!=null)
		return enterpass;
		else
			throw new RuntimeException("password  not specified");
		
	}

	
	
	
}
