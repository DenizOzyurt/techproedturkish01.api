package techproedturkish01.techproedturkish01.api;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class GetRequest15 extends TestBase {

	@Test
	public void getRequest15() {
		
		/*							Warm Up 10 Minutes
		 
		 When
			 	I send request to https://restful-booker.herokuapp.com/booking/3
			 Then
			        Status code is 200
			    And Content type is "application/json"
			    And Status line is "HTTP/1.1 200 OK"
			    And First name is Jim
			    And Total price is 623
			    And Deposit paid is true
			    And checkin date is 2020-03-18
			    
		  Use De-Serialization to convert Json response body to a Map. 
		  Then by using the map and soft assertion make assertion.  
   
*/

		
		spec02.pathParam("id", 3);
		Response response=given().spec(spec02).when().get("/{id}");
		response.prettyPrint();
		
		response.then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK")
		.body("firstname", Matchers.equalTo("Jim"),
				"totalprice",Matchers.equalTo(623),
				"depositpaid",Matchers.equalTo(false),
				"bookingdates.checkin",Matchers.equalTo("2017-06-29"));
		
		HashMap<String,Object> map= response.as(HashMap.class);
		SoftAssert sa=new SoftAssert();
		
		sa.assertEquals(map.get("firstname"), "Jim");
		sa.assertEquals(map.get("totalprice"),623);
		sa.assertEquals(map.get("depositpaid"),false);
		sa.assertTrue(map.get("bookingdates").toString().contains("2017-06-29"));
		sa.assertAll();
	}
}
