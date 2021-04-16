package Tests;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ScoutAPI.RestAssuredDemo.Base;
import ScoutAPI.RestAssuredDemo.payloads;



public class Loadwidgetdetails {

	

@Test(dataProvider="data")
	public static void LoadWidgetsDetails(int AccountId, int SectionId, int UserId, int ChartType, String StartDate,String EndDate) throws Exception {
		
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		RestAssured.baseURI = Base.Propertis("baseURI");

		String response = given().log().all().header("Content-Type", Base.Propertis("Content-Type")).header("access_token",Base.Propertis("access_token")).body(payloads.LoadWidgetsDetails(AccountId,  SectionId,  UserId,  ChartType,  StartDate, EndDate))
				.when().post("api/report/LoadWidgetsDetails")
				.then().log().all().assertThat().statusCode(200).body("scope", equalTo(null)).extract().response().asString();
		System.out.println(response);
		String hey=Base.JsonConverter(response, "Message");
		
		System.out.println(hey);
		
		Base.Assert(hey, "Success");
	/*	payloads p1=new payloads();
		p1.LoadProductionChart();*/
		//41728, 7, 2, 1, "", ""
		

	}
@DataProvider
public Object[][] data()
{
	Object[][] test={
			{41728, 7, 58779, 1, "", ""},
			{41728, 99, 58779, 1, "", ""},
			{41728, 7, 58779, 1, "", ""}};
	return test;
}

}
