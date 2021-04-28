package Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ScoutAPI.RestAssuredDemo.Base;

import Utilities.Reporting;

public class Listeners1234  implements ITestListener{
	ExtentTest test;
	ExtentReports extent=Reporting.extent;
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();

 //   private static Logger log = Logger.getLogger(Logging.class.getClass());
	
	public void onTestStart(ITestResult result)  {
		Object[] a=result.getParameters();
		Object k=a[13];
		
		test= (Reporting.extent).createTest((String) k);
		
		
	

		
	}

	public void onTestSuccess(ITestResult result) {
		
	test.log(Status.PASS, "Test Passed");
		
	} 

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Screenshot
		test.log(Status.FAIL, "Test Failed");
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
	/*
	 ExtentTest test;
	ExtentReports extent=Reporting.extent;
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();// that was for parallel tests
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Screenshot
		extentTest.get().fail(result.getThrowable());//test.fail when not in parallel
		WebDriver driver =null;
		String testMethodName =result.getMethod().getMethodName();
		
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		
		{}
	

}*/
}
