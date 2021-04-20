package ScoutAPI.RestAssuredDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;

public class payloads {

	static ArrayList a;

	public static String loadDashboard(Object a, Object b, Object c, Object d, Object e)
			throws JsonProcessingException {
		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("AccountId", a);
		map.put("UserId", b);
		map.put("ChartType", c);
		map.put("StartDate", d);
		map.put("EndDate", e);

		if (a == null) 
		{
			map.remove("AccountId");
		}
		if (b == null) 
		{
			map.remove("UserId");
		}
		if (c == null) 
		{
			map.remove("ChartType");
		}
		if (d == null) 
		{
			map.remove("StartDate");
		}
		if (e == null) 
		{
			map.remove("EndDate");
		}

		/* String string = mappert. toString(); */
		
		/*ObjectMapper objectMapper = new ObjectMapper();

		String json = objectMapper.writeValueAsString(map);*/

		return Base.MapToJSON(map);

		
	}

	public static String LoadWidgetsDetails(Object a, Object b, Object c, Object d, Object e,Object f) throws IOException {
		// TODO Auto-generated method stub
       Map<String, Object> map = new HashMap<String, Object>();
		map.put("AccountId", a);
		map.put("SectionId", b);
		map.put("UserId", c);
		map.put("ChartType", d);
		map.put("StartDate", e);
		map.put("EndDate", f);
		

		if (a == null) 
		{
			map.remove("AccountId");
		}
		if (b == null) 
		{
			map.remove("SectionId");
		}
		if (c == null) 
		{
			map.remove("UserId");
		}
		if (d == null) 
		{
			map.remove("ChartType");
		}
		if (e == null) 
		{
			map.remove("StartDate");
		}
		if (f == null) 
		{
			map.remove("EndDate");
		}

		/* String string = mappert. toString(); */
		return Base.MapToJSON(map);
				/*"{ \"AccountId\": " + a + ",\r\n" + "  \"SectionId\": " + b + ",\r\n" + "  \"UserId\": " + c + ",\r\n"
				+ "  \"ChartType\": " + d + ",\r\n" + "  \"StartDate\": \"" + e + "\",\r\n" + "   \"EndDate\":   \"" + f
				+ "\"\r\n" + "}";*/
	}

	public static String LoadProductionChart(Object a, Object b, Object c, Object d, Object e) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("AccountId", a);
		map.put("UserId", b);
		map.put("ChartType", c);
		map.put("StartDate", d);
		map.put("EndDate", e);

		if (a == null) 
		{
			map.remove("AccountId");
		}
		if (b == null) 
		{
			map.remove("UserId");
		}
		if (c == null) 
		{
			map.remove("ChartType");
		}
		if (d == null) 
		{
			map.remove("StartDate");
		}
		if (e == null) 
		{
			map.remove("EndDate");
		}

		/* String string = mappert. toString(); */
		return Base.MapToJSON(map);
		/*
		 * ArrayList data=getData("LoadWidgetDetails","TestCases","First");
		 * 
		 * System.out.println(data.get(0)); System.out.println(data.get(1));
		 * System.out.println(data.get(2)); System.out.println(data.get(3));
		 */
	//	return "{\r\n" + "    \"AccountId\": " + a + ",\r\n" + "    \"UserId\": " + b + ",\r\n" + "    \"ChartType\": "
		//		+ c + ",\r\n" + "    \"StartDate\": \"" + d + "\",\r\n" + "    \"EndDate\":   \"" + e + "\"\r\n" + "}";
	}

	public static String AddEditProduction(Object a, Object b, Object c, Object d, Object e, Object f, Object g,
			Object h, Object i, Object j, Object k) throws JsonProcessingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Id", a);
		map.put("AccountId", b);
		map.put("DoctorId", c);
		map.put("DailyGoal", d);
		map.put("WeeklyGoal", e);
		map.put("MonthlyGoal", f);
		map.put("YearlyGoal", g);
		map.put("WidgetId", h);
		map.put("Remark", i);
		map.put("IsActive", j);
		map.put("ActionBy", k);

		if (a == null) 
		{
			map.remove("Id");
		}
		if (b == null) 
		{
			map.remove("AccountId");
		}
		if (c == null) 
		{
			map.remove("DoctorId");
		}
		if (d == null) 
		{
			map.remove("DailyGoal");
		}
		if (e == null) 
		{
			map.remove("WeeklyGoal");
		}
		if (f == null) 
		{
			map.remove("MonthlyGoal");
		}
		if (g == null) 
		{
			map.remove("YearlyGoal");
		}
		if (h == null) 
		{
			map.remove("WidgetId");
		}
		if (i == null) 
		{
			map.remove("Remark");
		}
		if (j == null) 
		{
			map.remove("IsActive");
		}
		if (k == null) 
		{
			map.remove("ActionBy");
		}
		

		return Base.MapToJSON(map);
		/*
		// TODO Auto-generated method stub
		return "{\r\n" + "  \"Id\": " + a + ",\r\n" + "  \"AccountId\": " + b + ",\r\n" + "  \"DoctorId\": " + c
				+ ",\r\n" + "  \"DailyGoal\": " + d + ",\r\n" + "  \"WeeklyGoal\": " + e + ",\r\n"
				+ "  \"MonthlyGoal\": " + f + ",\r\n" + "  \"YearlyGoal\": " + g + ",\r\n" + "  \"WidgetId\": " + h
				+ ",\r\n" + "  \"Remark\": \"" + i + "\",\r\n" + "  \"IsActive\": " + j + ",\r\n" + "  \"ActionBy\": "
				+ k + "\r\n" + "}";
	}
*/
	}
}
