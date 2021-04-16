package Tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ScoutAPI.RestAssuredDemo.Base;
import ScoutAPI.RestAssuredDemo.payloads;
import Utilities.ExcelDataDriven;
import io.restassured.RestAssured;

public class LoadDashboardAPI {
	@Test(dataProvider="data")
	public static void loadDashboard(int AccountId,int UserId,int ChartType,String StartDate, String EndDate) throws Exception {
		
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		RestAssured.baseURI = Base.Propertis("baseURI");

		String response = given().log().all().header("Content-Type", Base.Propertis("Content-Type")).header("access_token",Base.Propertis("access_token")).body(payloads.loadDashboard(AccountId, UserId, ChartType, StartDate, EndDate))
				.when().post("api/report/LoadDashboardSummary")
				.then().log().all().assertThat().statusCode(200).body("scope", equalTo(null)).extract().response().asString();
		System.out.println(response);
		String hey=Base.JsonConverter(response,"Message");
		//System.out.println(hey);
		
		Base.Assert(hey, "Success");
		//41728, 3, 0, "2021-01-06T22:35:46.0327652-07:00", "2021-02-3T22:35:46.0327652-07:00"
		
		

	}
	@DataProvider
	public Object[][] data()
	{
		Object[][] test={
				{0, 12342, 0, "", ""},
				/*{41728, 3, 0, "2021-01-06T22:35:46.0327652-07:00", "2021-02-3T22:35:46.0327652-07:00"},
				{41728, 3, 0, "2021-01-06T22:35:46.03:00", "2021-02-3T22:35:46.0327652-07:00"}*/};
		return test;
	}

}
