package Tests;

import org.testng.ITestContext;
import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import ScoutAPI.RestAssuredDemo.Base;
import Utilities.Reporting;

public class Listeners extends Reporting implements ITestListener{
	
	Reporting r1 = new Reporting();
	public void onTestStart(ITestResult result)  {
		// TODO Auto-generated method stub
		
			
		
	
			
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Screenshot
	
		
		
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

}
