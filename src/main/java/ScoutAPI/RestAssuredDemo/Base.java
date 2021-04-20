package ScoutAPI.RestAssuredDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;

import io.restassured.path.json.JsonPath;

public class Base {
	
	
	static Properties prop;
	static String hu = System.getProperty("user.dir")+"\\Prop.properties";
	public  static String Propertis(String ab) throws IOException
	{
	 
	prop =new Properties();
		FileInputStream fis = new FileInputStream(hu);
		prop.load(fis);
		return prop.getProperty(ab);
		 
	}
	public static String JsonConverter(String response, String Element){
		JsonPath json = new JsonPath(response);
		String hey = json.getString(Element);
		return hey;
		}
	
	public static void Assert(String actual, String expected){
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual, expected);

	}
	
	
	
	public static String MapToJSON(Map<String, Object> a) throws JsonProcessingException
	{
		ObjectMapper objectMapper = new ObjectMapper();

		String json = objectMapper.writeValueAsString(a);
	return 	json;
	}

}
