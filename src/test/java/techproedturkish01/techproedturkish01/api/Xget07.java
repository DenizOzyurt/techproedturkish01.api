package techproedturkish01.techproedturkish01.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Xget07 extends TestBase {
	
//	* When I send a GET request to REST API URL
//	 * https://restful-booker.herokuapp.com/booking/5
//	 * Then HTTP Status Code should be 200
//	 * And response content type is “application/JSON”
//	 * And response body should be like;
//	 * {"firstname": "Sally", "lastname": "Ericsson", "totalprice": 111,
//	 * "depositpaid": false, "bookingdates": { "checkin": "2017-05-23", "checkout":"2019-07-02" }

/*
How to use JsonPath. We will use JsonPath to navigate inside the Json Data 
*/
	@Test
	public void Xget07() {
		Response response=given().spec(spec04).pathParam("id", 5).when().get("/{id}");
//		response.prettyPrint();
		
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
		
		JsonPath json=response.jsonPath();
		json.prettyPrint();
		
		System.out.println(json.getString("firstname"));
		assertEquals("Result in not expected","Susan",json.getString("firstname"));
		
		assertEquals("700",json.getString("totalprice"));
	
	}

}
