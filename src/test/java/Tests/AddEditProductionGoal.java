package Tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ScoutAPI.RestAssuredDemo.Base;
import ScoutAPI.RestAssuredDemo.payloads;
import Utilities.Reporting;
import io.restassured.RestAssured;

public class AddEditProductionGoal  {
	@Test(dataProvider="data")
	public static void AddEditProductionGoal(Object Id, Object AccountId, Object DoctorId, Object DailyGoal ,Object WeeklyGoal, Object MonthlyGoal,Object YearlyGoal,Object WidgetId,Object Remark, Object IsActive, Object  ActionBy, Object AssertionElement,Object AssertionElementExpected) throws Exception {
		
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = Base.Propertis("baseURI");

		String response = given().log().all().header("Content-Type", Base.Propertis("Content-Type")).header("access_token",Base.Propertis("access_token")).body(payloads.AddEditProduction(Id,AccountId,DoctorId,  DailyGoal , WeeklyGoal,  MonthlyGoal, YearlyGoal, WidgetId, Remark,  IsActive,   ActionBy))
				.when().post("api/report/AddEditProductionGoal")
				.then().log().all().assertThat().statusCode(200).body("scope", equalTo(null)).extract().response().asString();
		/*System.out.println(response);
		String hey=Base.JsonConverter(response,"Message");
		System.out.println(hey);*/
		
		Base.Assert(Base.JsonConverter(response,""+AssertionElement+""), ""+AssertionElementExpected+"");
		
		//Id, AccountId,DoctorId, DailyGoal, WeeklyGoal, MonthlyGoal, YearlyGoal, WidgetId, Remark, IsActive, ActionBy, AssertionElement, AssertionElementExpected
		//0, 41728, 58779, 4.5, 2.4, 3.5, 4.5, 6,"hey", true, 5
		Reporting.extent.createTest("Newone");
		
		
   
	}
	
	@DataProvider
	public Object[][] data()
	{
		//Integer b= Integer.valueOf(null);
Object[][] test={
//Id, AccountId,DoctorId, DailyGoal, WeeklyGoal, MonthlyGoal, YearlyGoal, WidgetId, Remark, IsActive, ActionBy, AssertionElement, AssertionElementExpected

				{0,     0,     0,   0,   0,   0,   0, 0,"hey",    0, 0,"IsSuccess",false},
				{0, 41728, 58779, 4.5, 2.4, 3.5, 4.5, 6,"hey", true, 5,"IsSuccess",true},
				{0, 41728, 58779,   1,   0,   0,   0, 6,"hey", true, 5,"IsSuccess",true},
				{0, 41728, 58760, 1.0,   0,   0,   0, 1,"Not corresponding to the accountId", true, 5,"IsSuccess",false},
				{2, 41856, 58915, 9.0, 1.8, 5.7, 6.8, 3,"hey", false, 1,"IsSuccess",true}
				
				
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
