package techproedturkish01.techproedturkish01.api;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest03 {
	
	/* 
	 When I send a GET request to REST API URL
	 https://restful-booker.herokuapp.com/booking/1
     And Accept type is “application/JSON”
     Then
     HTTP Status Code should be 200
     And Response format should be "application/JSON"
     And first name should be "Susan"
     And lastname should be "Brown"
     And checkin date should be "2015-02-16"
     And checkout date should be "2017-06-20"
	 */
	
	@Test
	public void get01() {
		Response response=given().when().get(" https://restful-booker.herokuapp.com/booking/1");
		response.prettyPrint();
		response.
			then().
			assertThat().
			statusCode(200).
			contentType(ContentType.JSON).
			body("firstname", equalTo("Mary")).
			body("lastname",equalTo("Jones")).
			body("totalprice",equalTo(746)).
			body("depositpaid",equalTo(true)).
			body("bookingdates.checkin",equalTo("2015-10-30")).
			body("bookingdates.checkout",equalTo("2017-01-06"));

	}
	
	@Test
	public void get02() {
		Response response=given().when().get(" https://restful-booker.herokuapp.com/booking/1");
		response.prettyPrint();
		response.
			then().
			assertThat().
			statusCode(200).
			contentType(ContentType.JSON).
			body("firstname", equalTo("Mary"),
					"lastname",equalTo("Jones"),
					"totalprice",equalTo(746),
					"depositpaid",equalTo(true),
					"bookingdates.checkin",equalTo("2015-10-30"),
					"bookingdates.checkout",equalTo("2017-01-06"));
			

	}

}
