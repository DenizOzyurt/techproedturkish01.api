package techproedturkish01.techproedturkish01.api;

import org.junit.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;


public class PostRequest01 extends TestBase {
	
	/*
	 To create Post Request in API, you need
	 1) Endpoint =>Mandatory
	 2) Request Body=>Mandatory
	 3) Autorisation =>Optional
	 4) 
	 */
	
	@Test
	public void post01() {
		
		//1.way : To create a request body ==> Create a String variable and
		//assign the Request Body into the variable
		

//		String reqBody="{\r\n" + 
//				"    \"bookingid\": 24,\r\n" + 
//				"    \"booking\": {\r\n" + 
//				"        \"firstname\": \"Veli\",\r\n" + 
//				"        \"lastname\": \"Can\",\r\n" + 
//				"        \"totalprice\": 333,\r\n" + 
//				"        \"depositpaid\": true,\r\n" + 
//				"        \"bookingdates\": {\r\n" + 
//				"            \"checkin\": \"2020-10-20\",\r\n" + 
//				"            \"checkout\": \"2020-11-04\"\r\n" + 
//				"        },\r\n" + 
//				"        \"additionalneeds\": \"Breakfast\"\r\n" + 
//				"    }\r\n" + 
//				"}";
//	
		
		Map<String,Object> reqBody=new HashMap<>();
		
		reqBody.put("firstname", "Ali");
		reqBody.put("lastname", "Can");
		reqBody.put("totalprice", 333);
		reqBody.put("deposit", true);
		
		Map<String,Object> bookingDatesReqBody=new HashMap<>();
		bookingDatesReqBody.put("checkin", "2020-09-14");
		bookingDatesReqBody.put("checkout", "2020-10-20");
		
		reqBody.put("bookingdates", bookingDatesReqBody);
		reqBody.put("additionalneeds", "Breakfast");
		
		Response response=given().
							spec(spec02).
							auth().
							basic("admin", "password123").
							body(reqBody).
							when().post();
	
		response.prettyPrint();
		
		response.then().assertThat().statusCode(200);
	
	
	}

}
