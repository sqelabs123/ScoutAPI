package ScoutAPI.RestAssuredDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;



public class payloads  {
	
	static ArrayList a;

public static String loadDashboard(Object a,Object b,Object c,Object d, Object e) throws JsonProcessingException {
		// TODO Auto-generated method stub
	
	
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("AccountId", a);
		map.put("UserId", b);
		map.put("ChartType", c);
		map.put("StartDate", d);
		map.put("EndDate", e);
		
		
	/*	switch (null)
		case a:  map.remove("AccountId");
		case b:  map.remove("UserId");
		case c:  map.remove("ChartType");
		case d:  map.remove("StartDate");
		case e:  map.remove("EndDate");*/
			
			
			
			
			
		if(a==null)
		{
			map.remove("AccountId");
		}
		if(b==null)
		{
			map.remove("UserId");
		}
		if(c==null)
		{
			map.remove("ChartType");
		}
		if(d==null)
		{
			map.remove("StartDate");
		}
		if(e==null)
		{
			map.remove("EndDate");
		}
		
		
		/*String string = mappert. toString();*/
		ObjectMapper objectMapper = new ObjectMapper();

        
            String json = objectMapper.writeValueAsString(map);
		
		
		
		return json;
		
		
		/*return "{\r\n" + 
		"    \"AccountId\": "+a+",\r\n" + 
		"    \"UserId\": "+b+",\r\n" + 
		"    \"ChartType\": "+c+",\r\n" + 
		"    \"StartDate\": \""+d+"\",\r\n" + 
		"    \"EndDate\":   \""+e+"\"\r\n" + 
		"}";*/
	}


public static String LoadWidgetsDetails(int a, int b, int c, int d, String e,String f) throws IOException {
	// TODO Auto-generated method stub
	
	 
	return "{ \"AccountId\": "+a+",\r\n" + 
	"  \"SectionId\": "+b+",\r\n" + 
	"  \"UserId\": "+c+",\r\n" + 
	"  \"ChartType\": "+d+",\r\n" + 
	"  \"StartDate\": \""+e+"\",\r\n" + 
	"   \"EndDate\":   \""+f+"\"\r\n" + 
	"}";
}

public  static String LoadProductionChart(int a, int b, int c, String d, String e) throws Exception {
	// TODO Auto-generated method stub


	/*ArrayList data=getData("LoadWidgetDetails","TestCases","First");

System.out.println(data.get(0));
System.out.println(data.get(1));
System.out.println(data.get(2));
System.out.println(data.get(3));*/
return "{\r\n" + 
	"    \"AccountId\": "+a+",\r\n" + 
	"    \"UserId\": "+b+",\r\n" + 
	"    \"ChartType\": "+c+",\r\n" + 
	"    \"StartDate\": \""+d+"\",\r\n" + 
	"    \"EndDate\":   \""+e+"\"\r\n" + 
	"}";
}


public static String AddEditProduction(Object a, Object b, Object c, Object d ,Object e, Object f,Object g,Object h,Object i, Object j, Object  k ) {
	// TODO Auto-generated method stub
	return "{\r\n" + 
			"  \"Id\": "+a+",\r\n" + 
			"  \"AccountId\": "+b+",\r\n" + 
			"  \"DoctorId\": "+c+",\r\n" + 
			"  \"DailyGoal\": "+d+",\r\n" + 
			"  \"WeeklyGoal\": "+e+",\r\n" + 
			"  \"MonthlyGoal\": "+f+",\r\n" + 
			"  \"YearlyGoal\": "+g+",\r\n" + 
			"  \"WidgetId\": "+h+",\r\n" + 
			"  \"Remark\": \""+i+"\",\r\n" + 
			"  \"IsActive\": "+j+",\r\n" + 
			"  \"ActionBy\": "+k+"\r\n" + 
			"}";
}

}
