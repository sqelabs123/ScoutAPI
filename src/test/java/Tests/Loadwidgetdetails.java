package Tests;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ScoutAPI.RestAssuredDemo.Base;
import ScoutAPI.RestAssuredDemo.payloads;
import Utilities.Assertions;



public class Loadwidgetdetails {

	

@Test(dataProvider="data")
	public static void LoadWidgetsDetails(int AccountId, int SectionId, int UserId, int ChartType, String StartDate,String EndDate, int statuscode,Map<String,Object> a) throws Exception {
		
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		RestAssured.baseURI = Base.Propertis("baseURI");

		String response = given().log().all().header("Content-Type", Base.Propertis("Content-Type")).header("access_token",Base.Propertis("access_token")).body(payloads.LoadWidgetsDetails(AccountId,  SectionId,  UserId,  ChartType,  StartDate, EndDate))
				.when().post("api/report/LoadWidgetsDetails")
				.then().log().all().assertThat().statusCode(statuscode).body("scope", equalTo(null)).extract().response().asString();
		System.out.println(response);
//		Base.Assert(Base.JsonConverter(response,""+AssertionElement+""), ""+AssertionElementExpected+"");
		/*String hey=Base.JsonConverter(response, "Message");
		
		System.out.println(hey);
		
		Base.Assert(hey, "Success");*/
	/*	payloads p1=new payloads();
		p1.LoadProductionChart();*/
		//41728, 7, 2, 1, "", ""
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
			{41728, 7, 58779, 1, null,null,200,Assertions.LoadProduction("m1")},
			/*{41728, 99, 58779, 1, null, null,200,Assertions.LoadProduction("m2")},
			{41728, 7, 58779, 1, "", "",200,Assertions.LoadProduction("m3")}*/};
	return test;
}

}
