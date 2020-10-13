package practice;


import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import techproedturkish01.techproedturkish01.api.TestBase;
import utilities.JsonUtil;


public class Practice08 extends TestBase {

	 /*
	 1)Use "http://api.openweathermap.org" as Base URI
	 2)Set the URL to "http://api.openweathermap.org/data/3.0/stations?appid=2cb6803f295233aa579843d9e45599f2"
	   by using pathParams() and queryParams() methods
	 3)Use JSONObject Class or MAP to store expected values
     Request Body should have:	"external_id": "SF_TEST001",
							    "name": "San Francisco Test Station",
							    "latitude": 37.76,
							    "longitude": -122.43,
							    "altitude": 150
	 4)Create POST Request to "http://api.openweathermap.org/data/3.0/stations?appid=2cb6803f295233aa579843d9e45599f2"
	   Print the response body on the console
	 5)Response Body should have: {
									    "ID": "5f7cda67cca8ce0001ef62f0", (Changes constantly)
									    "updated_at": "2020-10-06T20:58:15.687292423Z",(Changes constantly)
									    "created_at": "2020-10-06T20:58:15.687292369Z",(Changes constantly)
									    "user_id": "5f6df55e3da20c000743c7ad",(Depends on the user)
									    "external_id": "SF_TEST001",
									    "name": "San Francisco Test Station",
									    "latitude": 37.76,
									    "longitude": -122.43,
									    "altitude": 150,
									    "rank": 10,
									    "source_type": 5
									}  
	 5)Assert Status Code and Response Body details by using body() method
	 6)Assert Response Body details by using assertEquals() method and GSON   
	 7)Assert Response Body details by using Soft Assert and ObjectMapper                   
	*/
	@Test
	public void postPractice() {
		spec05.pathParams("data","data",
				          "id", 3.0,
				          "stations", "stations").
		      queryParam("appid", "2cb6803f295233aa579843d9e45599f2");
		
		Map<String, Object> postReqBody = new HashMap<>(); 
		postReqBody.put("external_id", "SF_TEST001");
		postReqBody.put("name", "San Francisco Test Station");
		postReqBody.put("latitude", 37.76);
		postReqBody.put("longitude", -122.43f);
		postReqBody.put("altitude", 150);
		
		Map<String, Object> expectedData = new HashMap<>();
		expectedData.put("user_id", "5f6df55e3da20c000743c7ad");
		expectedData.put("rank", 10);
		expectedData.put("source_type", 5);
		
		
		Response response = given().
				              contentType(ContentType.JSON).
				              spec(spec05).
				              body(postReqBody).
				           when().
				              post("/{data}/{id}/{stations}");
		response.prettyPrint();
		
		//Hard Assertion body()
		response.
		     then().
		     assertThat().
		     statusCode(201).
		     contentType(ContentType.JSON).
		     body("user_id", equalTo(expectedData.get("user_id")),
		    		"external_id",equalTo(postReqBody.get("external_id")),
		    		"name",equalTo(postReqBody.get("name")),
		    		"longitude",equalTo(postReqBody.get("longitude")),
		    		"altitude",equalTo(postReqBody.get("altitude")),
		    		"rank",equalTo(expectedData.get("rank")),
		    		"source_type",equalTo(expectedData.get("source_type")));

	//Hard Assertion with assertEquals()
	//GSON for De-Serialization
		
		Map<String,Object> actualData=response.as(HashMap.class);
		
		assertEquals(expectedData.get("user_id"),actualData.get("user_id"));
		assertEquals(postReqBody.get("external_id"),actualData.get("external_id"));
		assertEquals(postReqBody.get("name"),actualData.get("name"));
		assertEquals(postReqBody.get("latitude"),actualData.get("latitude"));
		assertEquals(postReqBody.get("altitude"),actualData.get("altitude"));
		assertEquals(expectedData.get("rank"),actualData.get("rank"));
		assertEquals(expectedData.get("source_type"),actualData.get("source_type"));
		
		//Soft Assertion by using Object Mapper 
		Map<String,Object> actualDataObjMap=JsonUtil.convertJsonToJava(response.asString(), HashMap.class);
		
		SoftAssert SA=new SoftAssert();
		SA.assertEquals(actualDataObjMap.get("user_id"), expectedData.get("user_id"));
		SA.assertEquals(actualDataObjMap.get("external_id"), postReqBody.get("external_id"));
		SA.assertEquals(actualDataObjMap.get("name"), postReqBody.get("name"));
		SA.assertEquals(actualDataObjMap.get("latitude"), postReqBody.get("latitude"));
		SA.assertEquals(actualDataObjMap.get("altitude"), postReqBody.get("altitude"));
		SA.assertEquals(actualDataObjMap.get("rank"), expectedData.get("rank"));
		SA.assertEquals(actualDataObjMap.get("source_type"), expectedData.get("source_type"));
		
		SA.assertAll();
		
		
		
		
		
}

}
