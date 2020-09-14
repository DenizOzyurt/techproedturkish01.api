package trials;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import techproedturkish01.techproedturkish01.api.TestBase2;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Trial2 extends TestBase2 {
	/* 
	 When I send a GET request to REST API URL
	 https://restful-booker.herokuapp.com/booking/1001
    Then HTTP Status Code should be 404
    And response body contains "Not Found"
    And response body does not contain "TechProEd"
	 */
	
	@Test
	public void trail2() {
		
		spec1.pathParam("id", 101);
		Response response=given().spec(spec1).given().get("/{id}");
		
		response.then().assertThat().statusCode(404);
		
		assertTrue(response.asString().contains("Not Found"));
		assertFalse(response.asString().contains("TEchProEd"));
	}
}
