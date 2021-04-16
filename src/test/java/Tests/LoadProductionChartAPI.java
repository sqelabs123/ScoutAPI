package Tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ScoutAPI.RestAssuredDemo.Base;
import ScoutAPI.RestAssuredDemo.payloads;
import io.restassured.RestAssured;

public class LoadProductionChartAPI {
	@Test(dataProvider="data")
	public static void LoadProductionChart(int AccountId, int UserId, int ChartType, String StartDate, String EndDate) throws Exception {
		
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		RestAssured.baseURI = Base.Propertis("baseURI");

		String response = given().log().all().header("Content-Type", Base.Propertis("Content-Type")).header("access_token",Base.Propertis("access_token")).body(payloads.LoadProductionChart(AccountId,  UserId,  ChartType,  StartDate,  EndDate))
				.when().post("api/report/LoadProductionChart")
				.then().log().all().assertThat().statusCode(200).body("scope", equalTo(null)).extract().response().asString();
		System.out.println(response);
		String hey=Base.JsonConverter(response,"Message");
		System.out.println(hey);
		
		Base.Assert(hey, "Success");
		//41729, 0, 2, "", ""

	}
	@DataProvider
	public Object[][] data()
	{
		Object[][] test={
				{41729, 0, 2, "", ""},
				{41729, 0, 2, "", ""},
				{41729, 0, 2, "", ""}};
		return test;
	}

}

