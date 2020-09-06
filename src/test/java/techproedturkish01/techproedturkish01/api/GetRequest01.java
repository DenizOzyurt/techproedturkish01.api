package techproedturkish01.techproedturkish01.api;

import org.junit.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequest01 {

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
	public void get01() {
	
		Response response=given().
							accept("application/json").//it means API will only accept JSON format data.
						  when().
							  get("https://restful-booker.herokuapp.com/booking/3");
		response.prettyPrint();//prettyPrint() prints the response body on the console
		
		response.
			then().
			assertThat().
			statusCode(200).
			contentType("application/json").
			statusLine("HTTP/1.1 200 OK");
	}
	
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
	public void get02() {
		Response response = given().
							when().
							   get(" https://restful-booker.herokuapp.com/booking/303");//there is no 303.th element so statusCode: 404
		response.prettyPrint();
		response.
			then().
			assertThat().
			statusCode(404).
			statusLine("HTTP/1.1 404 Not Found");
		
		//How to print headers.
		System.out.println(response.getHeaders());
		System.out.println(response.getHeader("Content-type")); //1.method
		System.out.println(response.getContentType());//2.Method
		
		
	}
}
