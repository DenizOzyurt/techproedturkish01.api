package practice;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import techproedturkish01.techproedturkish01.api.Practice4pojo;
import techproedturkish01.techproedturkish01.api.TestBase;
import utilities.JsonUtil;

public class Practice06 extends TestBase {

	/*
	 1)Create base url in TestBase Class for "http://api.openweathermap.org"
	 2)Set the URL to "http://api.openweathermap.org/data/2.5/weather?q=Istanbul&&appid="2cb6803f295233aa579843d9e45599f2"
	   by using pathParams() and queryParams() methods
	 3)Use JSONObject Class or MAP to store expected values
	   Expected Values are: "coord.lon" ==> 28.98f   
	                        "coord.lat" ==> 41.04f
	                        "weather.description" ==> "broken clouds"
	                        "base" ==> "stations"
	                        "main.feels_like" ==> 301.81f
	                        "visibility" ==> 10000
	                        "clouds.all" ==> 57
	                        "sys.country" ==> "TR"
	                        "timezone" ==> 10800
	                        "name" ==> "Istanbul"
	 4)Create GET Request to "http://api.openweathermap.org/data/2.5/weather?q=Istanbul&&appid="2cb6803f295233aa579843d9e45599f2"
	   Print the response body on the console
	 5)Assert Status Code and Response Body details by using body() method
	 6)Assert Response Body details by using assertEquals() method    
	 7)Assert Response Body details by using Soft Assert                   
	*/
          

		@Test
		public void getPractice() {
			
//			 1)Create base url in TestBase Class for "http://api.openweathermap.org"
// To create Base URL in TestBase we used a) RequestSpecification
										//b) RequestSpecBuilder()
			
//			 2)Set the URL to "http://api.openweathermap.org/data/2.5/weather?q=Istanbul"
			//How to add pathParam and querryParam
//			   by using pathParams() and queryParams() methods
			spec05.pathParams("data", "data",
					"id",2.5,
					"weather","weather");
			       spec05.queryParams("q","Istanbul","appid","2cb6803f295233aa579843d9e45599f2");
			

//			 3)Use JSONObject Class or MAP to store expected values
//			   Expected Values are: "coord.lon" ==> 28.98f   
//			                        "coord.lat" ==> 41.04f
//			                        "weather.description" ==> "broken clouds"
//			                        "base" ==> "stations"
//			                        "main.feels_like" ==> 301.81f
//			                        "visibility" ==> 10000
//			                        "clouds.all" ==> 57
//			                        "sys.country" ==> "TR"
//			                        "timezone" ==> 10800
//			                        "name" ==> "Istanbul
// 									"appid="2cb6803f295233aa579843d9e45599f2"	
			       //To store expected values we have 3 main options
			       //1)JSONObject  2)Map or List    3) POJO class

			  JSONObject expectedvalues=new JSONObject();
//			  Map<String,Object> expectedvalues=new HashMap<>();
			  
			  expectedvalues.put("statusCode", 200);
			  expectedvalues.put("coord.lon",28.98f);
			  expectedvalues.put("coord.lat", 41.04f);
			  expectedvalues.put("weather.description", "overcast clouds");
			  expectedvalues.put("base", "stations");
			  expectedvalues.put("main.feels_like", 297.54f);
			  expectedvalues.put("visibility", 10000);
			  expectedvalues.put("clouds.all", 100);
			  expectedvalues.put("sys.country", "TR");
			  expectedvalues.put("timezone", 10800);
			  expectedvalues.put("name", "Istanbul");

		       
//			 4)Create GET Request to "http://api.openweathermap.org/data/2.5/weather?q=Istanbul"
//			   Print the response body on the console
			  
			  Response response=given().spec(spec05).when().get("/{data}/{id}/{weather}");
			  response.prettyPrint();
			  
//			 5)Assert Status Code and Response Body details by using body() method
		//   MAke assertions a)body()    b)assertEquals(),assertTrue,assertFalse 
			  //c)SoftAssert() need ===> JsonPath or De-serialition
			  
			  
			  //			 6)Assert Response Body details by using assertEquals() method    
			  
			  //a)body()  
			  response.then().assertThat().statusCode(200).
			  			body("coord.lon",equalTo(expectedvalues.get("coord.lon")),
			  					"coord.lat",equalTo(expectedvalues.get("coord.lat")),
//			  					"weather[0].description",equalTo(expectedvalues.get("weather.description")),
			  					"base",equalTo(expectedvalues.get("base")),
//			  					"main.feels_like",equalTo(expectedvalues.get("main.feels_like")),
			  					"visibility",equalTo(expectedvalues.get("visibility")),
//			  					"clouds.all",equalTo(expectedvalues.get("clouds.all")),
			  					"sys.country",equalTo(expectedvalues.get("sys.country")),
			  					"timezone",equalTo(expectedvalues.get("timezone")),
			  					"name",equalTo(expectedvalues.get("name")));
			  
//			  b)assertEquals(),assertTrue,assertFalse
			  JsonPath json=response.jsonPath(); 
			  assertEquals(expectedvalues.getInt("statusCode"),response.getStatusCode());
			  assertEquals(expectedvalues.get("coord.lon"),json.get("coord.lon"));
			  assertEquals(expectedvalues.get("coord.lat"),json.get("coord.lat"));
			  assertEquals(expectedvalues.get("base"),json.get("base"));
			  assertEquals(expectedvalues.get("visibility"),json.get("visibility"));

			  assertEquals(expectedvalues.get("sys.country"),json.get("sys.country"));
			  assertEquals(expectedvalues.get("timezone"),json.get("timezone"));
			  assertEquals(expectedvalues.get("name"),json.get("name"));
			  
			  
			  
			  //			 7)Assert Response Body details by using Soft Assert                   
			
	
		
		}

	}


