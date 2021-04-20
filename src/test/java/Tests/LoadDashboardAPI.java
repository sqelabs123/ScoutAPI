package Tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ScoutAPI.RestAssuredDemo.Base;
import ScoutAPI.RestAssuredDemo.payloads;
import Utilities.Assertions;
import Utilities.ExcelDataDriven;
import io.restassured.RestAssured;

public class LoadDashboardAPI {
	@Test(dataProvider="data")
	public static void loadDashboard(Object AccountId,Object UserId,Object ChartType,Object StartDate, Object EndDate, int statuscode,Map<String,Object> a) throws Exception {
		
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		RestAssured.baseURI = Base.Propertis("baseURI");

		String response = given().log().all().header("Content-Type", Base.Propertis("Content-Type")).header("access_token",Base.Propertis("access_token")).body(payloads.loadDashboard(AccountId, UserId, ChartType, StartDate, EndDate))
				.when().post("api/report/LoadDashboardSummary")
				.then().log().all().assertThat().statusCode(statuscode).body("scope", equalTo(null)).extract().response().asString();
		System.out.println(response);
//		String hey=Base.JsonConverter(response,"Message");
		//System.out.println(hey);
	/*	Base.Assert(Base.JsonConverter(response,""+AssertionElement+""), ""+AssertionElementExpected+"");*/
		
//		Base.Assert(hey, "Success");
		//41728, 3, 0, "2021-01-06T22:35:46.0327652-07:00", "2021-02-3T22:35:46.0327652-07:00"
		for (Map.Entry<String, Object> pair : a.entrySet()) {
			   //System.out.println(pair.getKey(), pair.getValue());   
			String s=pair.getKey();
			String l=String.valueOf(pair.getValue());
			Base.Assert(Base.JsonConverter(response,""+s+""), ""+l+"");
			}
		

	}
	@DataProvider
	public Object[][] data()
	{
		Object[][] test={
				{41728, 12342, null, null, null, 400,Assertions.LoadDashboard("m1")}
				/*,{41728, 3, 0, "2021-01-06T22:35:46.0327652-07:00", "2021-02-3T22:35:46.0327652-07:00"},
				{41728, 3, 0, "2021-01-06T22:35:46.03:00", "2021-02-3T22:35:46.0327652-07:00"}*/};
		return test;
	}

}
