package techproedturkish01.techproedturkish01.api;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class Xget01 {

	/*
	 * Negatif Scenirio
	 When I send a GET Request to the
	  URL https://restful-booker.herokuapp.com/booking/303
	 then
	 HTTP Status code should be 404
	 And Content type should be Json
	 And Status line should be HTTP/1.1 404 Not Found
	 */
	
	@Test
	public void get01() {
		Response response=given().when().get("https://restful-booker.herokuapp.com/booking/3");
		response.prettyPrint();
		
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
	}
}
