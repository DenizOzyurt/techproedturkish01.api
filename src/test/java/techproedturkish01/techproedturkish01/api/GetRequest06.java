package techproedturkish01.techproedturkish01.api;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequest06 extends TestBase {
	/*
	 Among the data there should be someone whose first name is Susan
	 URL: https://restful-booker.herokuapp.com/booking
	 
	 */

	@Test
	public void get01() {
		
		spec02.queryParam("firstname", "Paul");
		spec02.queryParam("lastname", "McCartney");
		Response response=given().spec(spec02).when().get();
		response.prettyPrint();
		
		response.then().assertThat().statusCode(200);
//		assertTrue(response.asString().contains("bookingid"));
	
	}
	
}
