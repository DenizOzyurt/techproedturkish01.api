package techproedturkish01.techproedturkish01.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequest07 extends TestBase {

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
	public void get01() {
		spec02.pathParam("bookingid", 5);
		
		Response response=given().spec(spec02).when().get("/{bookingid}");
		response.prettyPrint();
		
		JsonPath json=response.jsonPath();
		System.out.println(json.getString("firstname"));
		assertEquals("First name is not as expected","Mark",json.getString("firstname"));
		
				
		System.out.println(json.getString("lastname"));
		assertEquals("Last name is not as expected","Smith",json.getString("lastname"));
		
		System.out.println(json.getInt("totalprice"));
		assertEquals("Prize is not as expected",698,json.getInt("totalprice"));
		
		System.out.println(json.getBoolean("depositpaid"));
		assertEquals("Depozit is not as expected",true,json.getBoolean("depositpaid"));
		
		System.out.println(json.getString("bookingdates.checkin"));
		assertEquals("CheckIn is not as expected","2020-08-06",json.getString("bookingdates.checkin"));
		
		System.out.println(json.getString("bookingdates.checkout"));
		assertEquals("CheckOut is not as expected","2020-08-17",json.getString("bookingdates.checkout"));
		
	}
}
