package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	String path="C:\\Users\\Devendra\\eclipse-workspace\\MyStoreV1\\Configuration\\config.properties";
	
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
	
	public String getemail()
	{
		String emailadd =properties.getProperty("email");
		if(emailadd!=null)
		return emailadd;
		else
			throw new RuntimeException("email not specified");
		
	}

	
	
	
}
