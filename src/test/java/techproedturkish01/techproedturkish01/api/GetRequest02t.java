package techproedturkish01.techproedturkish01.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetRequest02t {
	
	/* 
	 When I send a GET request to REST API URL
	 https://restful-booker.herokuapp.com/booking/1001
     Then HTTP Status Code should be 404
     And response body contains "Not Found"
     And response body does not contain "TechProEd"
	 */
	
	@Test
	public void get01() {
		
		Response response=given().when().get("https://restful-booker.herokuapp.com/booking/1001");
		response.prettyPrint();
		response.then().assertThat().statusCode(404); //1.Way to assert status code
		
		assertEquals(404,response.statusCode()); //2.way to assert status code
												 //When we use asserEquals method make the the 
												//1.parameter expected, and 2.parameter actual
	assertTrue(response.asString().contains("Not Found"));
	//When you use assertTrue(), put a boolean as parameter.
	//If the boolean is true your test will pass otherwise it will fail,
		
	assertFalse(response.asString().contains("TechProEd"));
	
	
	}

}
