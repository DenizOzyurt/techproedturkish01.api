package techproedturkish01.techproedturkish01.api;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Xget03 {
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
		Response response=given().
							
							when().
								get(" https://restful-booker.herokuapp.com/booking/1");
		response.prettyPrint();
		
		response.then().assertThat().contentType(ContentType.JSON).statusCode(200).body("firstname", equalTo("Sally")).
		body("lastname",equalTo("Brown")).body("bookingdates.checkin",equalTo("2018-06-20"))
		;
		
				
	}
}
