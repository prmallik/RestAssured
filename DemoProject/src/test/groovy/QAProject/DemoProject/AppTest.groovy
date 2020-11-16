package QAProject.DemoProject;

import io.restassured.RestAssured;
import spock.lang.*;
import spock.util.*;
import io.restassured.path.json.JsonPath;
import groovy.util.*;
import groovy.lang.*;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.wwt.test.rest_demo.*;

import groovyjarjarantlr.collections.List;
import io.restassured.response.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends spock.lang.Specification {
	/**
	 * Rigorous Test :-)
	 * @return 
	 * 
	 * @throws ParseException
	 */

	
	@Test
	
	public void testThatAllPropConstainsData() throws ParseException

	{
		String r = EndPointValidator.getResponse("https://cat-fact.herokuapp.com/facts/", "GET", null);
		System.out.println("o/p - \n" + r);

		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(r);

		System.out.println("o/p - all Obj \n" + obj.get("all"));
		Assert.assertNotNull(obj.get("all"));
	
		
		
//		JSONArray arr = (JSONArray) obj.get("all");
//		int length = arr.size();
//		System.out.print("abcdef" + length);
//		for(int i=0; i<length; i++) {
//		  JSONObject jsonObj = (JSONObject) arr.get(i);
		

		 
		  }
	

	


	@Test
	public void testThatStatusCodeIs200()

	{
		int statusCode = EndPointValidator.getStatusCode("https://cat-fact.herokuapp.com/facts/", "GET", null);
		System.out.println("o/p - \n" + statusCode);
		Assert.assertEquals(statusCode, 200);
	}
}
