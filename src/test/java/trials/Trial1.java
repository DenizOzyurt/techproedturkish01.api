package trials;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import techproedturkish01.techproedturkish01.api.TestBase2;

public class Trial1 extends TestBase2 {
	/*
	 * Positif Scenirio
	 When I send a GET Request to the
	  URL https://restful-booker.herokuapp.com/booking/3
	 then
	 HTTP Status code should be 200
	 And Content type should be Json
	 And Status line should be HTTP 1.0 200 OK
	 */
	
	@Test
	public void trial01() {
		spec1.pathParam("id", 3);
		Response response =given().spec(spec1).get("/{id}");
		response.prettyPrint();
		
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
	}
	
}
