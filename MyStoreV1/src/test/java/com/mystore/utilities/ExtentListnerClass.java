package com.mystore.utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListnerClass implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configurationReport()
	{
		htmlReporter=new ExtentSparkReporter("ExtentListenerReportDemo.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);

		//add system info 
		reports.setSystemInfo("Machine", "DevendraPC1");
		reports.setSystemInfo("os", "window 8");
		reports.setSystemInfo("Browser", "chrome");
		reports.setSystemInfo("username", "Devendra");

		//configuration 
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my first report");
		htmlReporter.config().setTheme(Theme.DARK);

	}



	//onstart method is called when any test starts.
	public void onStart(ITestContext Result)
	{
		configurationReport();
		System.out.println("on start method is invoked");
	}

	//onfinish method is called after all test are executed
	public void onFinish(ITestContext Result)
	{
		System.out.println("on finish method invoked");
		reports.flush();
		//it is mendatory to call flush method to ensure information is written to the started reporter

	}
	
	//when test case get failed,this method is called 
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of test method failed " +Result.getName());
		test=reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of TestCases is" +Result.getName(), ExtentColor.RED));
	
		String screenshotpath=System.getProperty("user.dir") +"\\Screenshots\\" +Result.getName() +".png";
		File screenshotfile=new File(screenshotpath);
		
		if(screenshotfile.exists())
		{
			test.fail("captured screenshot is below" +test.addScreenCaptureFromPath(screenshotpath));
		}
		
		//test.addScreenCaptureFromPath(null)
	
	
	}
	
	//when test case get skipped,this method is called 
		public void onTestSkipped(ITestResult Result)
		{
			System.out.println("Name of test method skipped " +Result.getName());
			test=reports.createTest(Result.getName());
			test.log(Status.SKIP, MarkupHelper.createLabel("Name of TestCases is" +Result.getName(), ExtentColor.YELLOW));
		}


		//when on test case get started, this method is called
		public void onTestStart(ITestResult Result)
		{
			System.out.println("Name of the method started:" +Result.getName() );
			
		}
		
		//when test case get passed,this method is called 
				public void onTestSuccess(ITestResult Result)
				{
					System.out.println("Name of test method Success " +Result.getName());
					test=reports.createTest(Result.getName());
					test.log(Status.PASS, MarkupHelper.createLabel("Name of TestCases is" +Result.getName(), ExtentColor.GREEN));
				}
				
				public void onTestfailureButWithinSuccessPercentage(ITestResult Result)
				{
					
				}
		
		
		
		
		



}
