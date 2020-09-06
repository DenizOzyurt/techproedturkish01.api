package techproedturkish01.techproedturkish01.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Xget02 {

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
		
		response.then().assertThat().statusCode(404);
		response.asString().contains("Not Found");
		
		assertEquals(404,response.statusCode());
//		assertTrue(response.asString().contains("TechProEd"));
		assertFalse(response.asString().contains("AliCan"));
	
	}
}
