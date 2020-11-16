package com.wwt.test.rest_demo;

import org.junit.Assert;
import io.restassured.response.*;
import org.json.simple.JSONObject;
import static org.junit.Assert.assertEquals;				
import static org.junit.Assert.assertFalse;				

import java.util.ArrayList;	
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.*;
        

import org.junit.After;		
import org.junit.AfterClass;		
import org.junit.Before;		
import org.junit.BeforeClass;		
import org.junit.Ignore;		
import org.junit.Test;	

public class EndPointValidator {
	//String url = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
	
	public static String getResponse(String url, String method, JSONObject requestBody) {
		String r =  given().when().contentType("application/json").get(url).getBody().asString();
		return r;
		
	}
	
	public static int getStatusCode(String url, String method, JSONObject requestBody) {
		int statusCode= given().when().get(url).getStatusCode();
		return statusCode;
		
	}
	
}
