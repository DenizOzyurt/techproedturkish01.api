package trials;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import techproedturkish01.techproedturkish01.api.TestBase2;

public class trial6 extends TestBase2 {

	
//		* When I send a GET request to REST API URL
//		 * https://restful-booker.herokuapp.com/booking/5
//		 * Then HTTP Status Code should be 200
//		 * And response content type is “application/JSON”
//		 * And response body should be like;
//		 * {"firstname": "Sally", "lastname": "Ericsson", "totalprice": 111,
//		 * "depositpaid": false, "bookingdates": { "checkin": "2017-05-23", "checkout":"2019-07-02" }

		@Test
		public void trial6() {
			spec1.pathParam("id", 5);
			Response response= given().spec(spec1).when().get("/{id}");
			response.prettyPrint();
			
			response.then().statusCode(200).contentType(ContentType.JSON);
			
			JsonPath json=response.jsonPath();
			Map<String,Object> jsonm=json.getMap(DEFAULT_PATH);
		
			System.out.println(jsonm);
			assertEquals("Result is not expected","Susan",json.getString("firstname"));
		

	}

}
