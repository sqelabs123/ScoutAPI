package Utilities;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.*;

public class Reporting  {
     // ExtentSparkReporter
	
	public static ExtentReports extent;
	//String path;
	//try{

	@BeforeTest

	public void config() throws Exception

	{

		// ExtentReports , ExtentSparkReporter

		 String path = System.getProperty("user.dir") + "\\reports\\index.html";
 
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Results");

		reporter.config().setDocumentTitle("Tes");
		
		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Vishal");

	}
}

	
	
	


