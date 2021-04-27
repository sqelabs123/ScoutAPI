package Tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import ScoutAPI.RestAssuredDemo.Base;
import ScoutAPI.RestAssuredDemo.payloads;
import Utilities.Assertions;
import Utilities.Reporting;
import groovy.util.logging.Log;
import io.restassured.RestAssured;

public class AddEditProductionGoal extends Reporting  {
	//private static Logger log= Logger.getLogger(AddEditProductionGoal.class.getName());
	
	
	
	static ExtentTest test;
	/*@BeforeMethod
	public void initaialise() throws Exception
	{
       test = Reporting.extent.createTest("ABC");
       
	}*/
	
	
	@Test(dataProvider="data")
	public static void AddEditProductionGoals(Object Id, Object AccountId, Object DoctorId, Object DailyGoal ,Object WeeklyGoal, Object MonthlyGoal,Object YearlyGoal,Object WidgetId,Object Remark, Object IsActive, Object  ActionBy, int statuscode,Map<String,Object> a,Object y) throws Exception {
//		System.out.println(Id);
		//String Testname=(String) y;
		// test = Reporting.extent.createTest((String) y);
		
		RestAssured.baseURI = Base.Propertis("baseURI");

		String response = given().log().all().header("Content-Type", Base.Propertis("Content-Type")).header("access_token",Base.Propertis("access_token")).body(payloads.AddEditProduction(Id,AccountId,DoctorId,  DailyGoal , WeeklyGoal,  MonthlyGoal, YearlyGoal, WidgetId, Remark,  IsActive,   ActionBy))
				.when().post("api/report/AddEditProductionGoal")
				.then().log().all().assertThat().statusCode(statuscode).body("scope", equalTo(null)).extract().response().asString();
		/*System.out.println(response);
		String hey=Base.JsonConverter(response,"Message");
		System.out.println(hey);*/
		
		for (Map.Entry<String, Object> pair : a.entrySet()) {
		   //System.out.println(pair.getKey(), pair.getValue());   
		String s=pair.getKey();
		String l=String.valueOf(pair.getValue());
		
	   	Base.Assert(Base.JsonConverter(response,""+s+""), ""+l+"");
		}
		
		
		
		
		//Id, AccountId,DoctorId, DailyGoal, WeeklyGoal, MonthlyGoal, YearlyGoal, WidgetId, Remark, IsActive, ActionBy, AssertionElement, AssertionElementExpected
		//0, 41728, 58779, 4.5, 2.4, 3.5, 4.5, 6,"hey", true, 5
	
		
		
   
	}
	
	@DataProvider
	public Object[][] data()
	{
		
		
		//Integer b= Integer.valueOf(null);
Object[][] test={
		
		
//Id, AccountId,DoctorId, DailyGoal, WeeklyGoal, MonthlyGoal, YearlyGoal, WidgetId, Remark, IsActive, ActionBy,Status Code, Assertions.API("m1"), Testname

				{null,  null,  null,null,   null, null, null, null,"hey",    null, null, 400, Assertions.AddEditProduction("m1"),"First"},
			    {null, 41728, 58779, 4.5,   null, null, null,    6, null,    null,    1, 200, Assertions.AddEditProduction("m2"),"Second"},
				{null, 41728, 58779,   1,   null, null, null, 6,"hey", true, 5,200, Assertions.AddEditProduction("m3"),"Third"},
				{null, 41728, 58760, 1.0,   null, null, null, 1,"Not corresponding to the accountId", true, 5,400, Assertions.AddEditProduction("m4"),"Fourth"},
				{   2, 41856, 58915, 9.0,    1.8, 5.7, 6.8, 3,"hey", false,5,200, Assertions.AddEditProduction("m5"),"Fifth"}
				
				
				};
/*{
  "Id": 2,
  "AccountId": 41856,
  "DoctorId": 58915,
  "DailyGoal": 9.0,
  "WeeklyGoal": 1.8,
  "MonthlyGoal": 5.7,
  "YearlyGoal": 6.8,
  "WidgetId": 3,
  "Remark": "sample string 4",
"IsActive": false,
  "ActionBy": 1
}*/
		return test;
	}
	

}
