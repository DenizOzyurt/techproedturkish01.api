package techproedturkish01.techproedturkish01.api;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class PostRequest02 extends TestBase{
	/*
	 {
			    "firstname": "Suleyman",
			    "lastname": "Alptekin",
			    "totalprice": 123,
			    "depositpaid": true,
			    "bookingdates": {
			        "checkin": "2020-05-02",
			        "checkout": "2020-05-05"
			    },
			    "additionalneeds": "Wifi"
		    }
	 */
	
	
	@Test
	public void post01() {
		
		//2.Way to create Request Body: Use JSONObject Class
		
		JSONObject reBody=new JSONObject();
		reBody.put("firstname", "Ali");
		reBody.put("lastname", "Can");
		reBody.put("totalprice", "333");
		reBody.put("depositpaid", true);
		
		JSONObject bookingDatesReqBody=new JSONObject();
		bookingDatesReqBody.put("checkin", "2020-05-02");
		bookingDatesReqBody.put("checkout", "2020-05-05");
		
		reBody.put("additionalneeds", "Wifi");
		
		reBody.put("additionalneeds",bookingDatesReqBody);
		
		Response response=given().spec(spec02).
									auth().
									basic("admin", "password123").
									body(reBody.toString()).
									when().
									post();
	
	response.prettyPrint();
	
	response.then().statusCode(200);
	
	}

}
