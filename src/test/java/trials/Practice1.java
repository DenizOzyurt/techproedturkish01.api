package trials;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.response.Response;
import techproedturkish01.techproedturkish01.api.TestBase;

public class Practice1 extends TestBase {

	/*
	 When 
	    I send a GET request to REST API URL 
	    https://restful-booker.herokuapp.com/booking/1001   
   Then 
      HTTP Status Code should be 404
      And response body contains "Not Found"
      And response body does not contain "JavaApi" 
      And header "Server" should be "Cowboy"
      And header "Content-Type" should be "text/plain; charset=utf-8"
      And header "Via" should be "1.1 vegur"

      Note: For Base URL use spec02
      Note: Use Map for expected values
      Note: Use Hard Assertion and Soft Assertion
*/
	@Test
	public void practice1() {
		//1.Get URI
		spec02.pathParam("id", 1001);
		Response response=given().spec(spec02).when().get("/{id}");
		response.prettyPrint();
		
		//2.Expected part
		Map<String,String> expected=new HashMap<>(); 
		expected.put("Server","Cowboy");
		expected.put("Content-Type","text/plain; charset=utf-8");
		expected.put("Via","1.1 vegur");
		expected.put("realC","Not Found");
		expected.put("fakeC","JavaApi");
		
		//3. hard assertion
		response.then().assertThat().statusCode(404).
		headers("Server",Matchers.equalTo(expected.get("Server")),
				"Content-Type",Matchers.equalTo(expected.get("Content-Type")),
				"Via",Matchers.equalTo(expected.get("Via")));
		
		assertTrue(response.asString().contains(expected.get("realC")));
		assertFalse(response.toString().contains(expected.get("fakeC")));
//		  Then 
//	      HTTP Status Code should be 404
//	      And response body contains "Not Found"
//	      And response body does not contain "JavaApi" 
//	      And header "Server" should be "Cowboy"
//	      And header "Content-Type" should be "text/plain; charset=utf-8"
//	      And header "Via" should be "1.1 vegur"
		
	}
}
