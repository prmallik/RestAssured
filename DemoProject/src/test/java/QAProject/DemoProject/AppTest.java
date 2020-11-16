package QAProject.DemoProject;

import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.internal.util.IOUtils;
import spock.lang.*;
import spock.util.*;
import io.restassured.path.json.JsonPath;
import groovy.util.*;
import groovy.lang.*;

import static org.junit.Assert.*;

import java.io.InputStream;

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
public class AppTest {
	/**
	 * Rigorous Test :-)
	 * 
	 * @return
	 * 
	 * @throws ParseException
	 */
	static int count = 284;
	static String auth = "{\r\n" + "\"name\":\"Priyanka\",\r\n"
			+ "\"AuthToken\":\"ygfyjgkuhklhkugyjyjgukhouguyfgiu7t6587tygiygjtr76r87tygiukbghhkjguyt87\"\r\n" + "}";

	@Test
	public void TC_01_test_That_ResponseIsNotNull() throws ParseException

	{
		String r = EndPointValidator.getResponse("https://cat-fact.herokuapp.com/facts/", "GET", null);
		System.out.println("o/p - \n" + r);

		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(r);

		System.out.println("o/p - all Obj \n" + obj.get("all"));
		Assert.assertNotNull(obj.get("all"));

	}

	@Test
	public void TC_02_test_The_CountOfResponse_Objects_In_Array() throws ParseException

	{
		String r = EndPointValidator.getResponse("https://cat-fact.herokuapp.com/facts/", "GET", null);
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(r);
		JSONArray arr = (JSONArray) obj.get("all");

		int length = arr.size();
		System.out.print("The length is " + length);
		Assert.assertEquals(count, length);

	}

	@Test
	public void TC_03_test_That_StatusCode_Is_200()

	{
		int statusCode = EndPointValidator.getStatusCode("https://cat-fact.herokuapp.com/facts/", "GET", null);
		System.out.println("o/p - \n" + statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void TC_04_test_the_Auth_Header_passing_Token() throws ParseException

	{
		String r = EndPointValidator.getResponse("https://gorest.co.in/access-token", "POST", null);
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(auth);//we can read from the above response, hardcoding as I didnt get one online. Any login endpoint would return this
		String token = obj.get("AuthToken").toString();
		String response1 = EndPointValidator.getResponseWithHeader("https://gorest.co.in/public-api/users", "GET", null,
				token);
		JSONObject obj1 = (JSONObject) parser.parse(response1);
		System.out.print("Object" + obj1);
		Assert.assertNotNull(obj1.get("data"));

	}

}
