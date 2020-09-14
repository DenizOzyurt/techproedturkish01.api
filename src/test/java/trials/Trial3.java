package trials;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import techproedturkish01.techproedturkish01.api.TestBase2;

public class Trial3 extends TestBase2 {

	
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
		public void trial03()  {
			spec1.pathParam("id",1);
			Response response=given().spec(spec1).get("/{id}");
			response.prettyPrint();
			
			response.then().assertThat().statusCode(200).
			contentType(ContentType.JSON).
						body("firstname",Matchers.equalTo("Susan"),
								"lastname",Matchers.comparesEqualTo("Smith"),
							"bookingdates.checkin",Matchers.equalTo("2019-12-03")
							);
			

	}

}
