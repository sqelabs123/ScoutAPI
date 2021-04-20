package Utilities;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.*;

public class Reporting  {
     // ExtentSparkReporter
	
	public  ExtentReports extent;
	

	public  ExtentReports config() throws Exception

	{
		try{

		 String path = System.getProperty("user.dir") + "\\reports\\index.html";
 
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Results");

		reporter.config().setDocumentTitle("Test");
		
		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Vishal");
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return extent;

	}
}

	
	
	


