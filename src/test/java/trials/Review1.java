package trials;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import techproedturkish01.techproedturkish01.api.TestBase;

import static io.restassured.RestAssured.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Review1 extends TestBase{


	/*							Warm Up 10 Minutes
	 
	 When
		 	I send request to https://restful-booker.herokuapp.com/booking/5
		 Then
		        Status code is 200
		    And Content type is "application/json"
		    And Status line is "HTTP/1.1 200 OK"
		    And First name is Jim
		    And Total price is 623
		    And Deposit paid is true
		    And checkin date is 2020-03-18
		    
			*use spec 2
			*use Json format 
			*use map format  (we can use utulities class)/ we can convert directly
			
			*use softAssertion
			
*/

	
	@Test
	public void review1() {
		
//		 When
//		 	I send request to https://restful-booker.herokuapp.com/booking/5
		
		spec02.pathParam("bookingId", 5);
		Response response =given().spec(spec02).when().get("/{bookingId}");
		response.prettyPrint();
		Map<String,Object> ben=response.as(HashMap.class);
		System.out.println(ben);
//		 Then
//		        Status code is 200
//		    And Content type is "application/json"
//		    And Status line is "HTTP/1.1 200 OK"
//	    And First name is Jim
//	    And Total price is 623
//	    And Deposit paid is true
//	    And checkin date is 2020-03-18
		response.then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK").
						body("firstname",Matchers.equalTo(ben.get("firstname")),
								"totalprice",Matchers.equalTo(ben.get("totalprice")),
								"depositpaid",Matchers.equalTo(ben.get("depositpaid")));
//								,"bookingdates.checkin",Matchers.equalTo("2017-01-26")
		
	    
//			*use spec 2
//			*use Json format 
//			*use map format  (we can use utulities class)/ we can convert directly
		
		JsonPath sen=response.jsonPath();
		SoftAssert SA=new SoftAssert();
		SA.assertEquals(sen.get("firstname"), ben.get("firstname"));
		SA.assertEquals(sen.get("bookingdates.checkin"),"2017-01-26" );
		
		int salary=sen.getInt("totalprice");
		
		System.out.println(salary);
		
		
		
		SA.assertAll();
		
//			
//			*use softAssertion
	}
}
