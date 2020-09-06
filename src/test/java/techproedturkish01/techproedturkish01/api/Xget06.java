package techproedturkish01.techproedturkish01.api;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Xget06 extends TestBase {


	
		/*
		 Among the data there should be someone whose first name is Susan
		 URL: https://restful-booker.herokuapp.com/booking
		 
		 */
		@Test
		public void Xget06() {
		
//			Response response=given().spec(spec02).pathParam("bookingid", 10).when().get("/{bookingid}");
	
			
			Response response=given().spec(spec02).queryParam( "firstname","Mark").when().get();
			response.prettyPrint();
			response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
			assertTrue(response.asString().contains("bookingid"));

	}

}
