package ScoutAPI.RestAssuredDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

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
		Assert.assertEquals(actual, expected);

	}

}
