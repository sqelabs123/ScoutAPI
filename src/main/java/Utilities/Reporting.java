package Utilities;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.*;

public class Reporting  {
     // ExtentSparkReporter
	
	public static  ExtentReports extent;
	
     @BeforeSuite
	public  void config() throws Exception

	{
		try{
			extent = new ExtentReports();
		 String path = System.getProperty("user.dir") + "\\reports\\extent.html";
 
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Results");

		reporter.config().setDocumentTitle("Test");
		
		

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Vishal");
		//test.log(Status.PASS,"Assert is Equals");
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	@AfterSuite
	public void teardown()
	{
		extent.flush();
	}
}

	
	
	


