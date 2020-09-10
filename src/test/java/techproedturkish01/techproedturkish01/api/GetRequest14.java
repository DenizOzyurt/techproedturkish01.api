package techproedturkish01.techproedturkish01.api;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class GetRequest14 extends TestBase {
/*
 
Süleyman Alptekin  3:24 AM
{
  “firstname”: “Mark”,
  “lastname”: “Jones”,
  “totalprice”: 198,
  “depositpaid”: true,
  “bookingdates”: {
    “checkin”: “2019-06-27”,
    “checkout”: “2019-07-26”
  },
  “additionalneeds”: “Breakfast”
}
 */
	/*
	 When I sent request to "https://restful-booker.herokuapp.com/booking"
	 Then 
	 status code is 200
	 And Content Type is "application/Json"
	 And Status Line is "HTTP 1.1 200 OK"
	 And First name is Mark
	 And Check In date is 2019-06-27
	 And Deposit paid is True
	 
	 Do the assertion  1) by using hard assertion 
	 */
	@Test
	public void test() {
		
		Response response = given().spec(spec02).pathParam("bookingid", 3).get("/{bookingid}");
		response.prettyPrint();
		
		response.then().assertThat().
			statusCode(200).
		contentType(ContentType.JSON).
			statusLine("HTTP/1.1 200 OK").
		body("firstname", Matchers.equalTo("Mark"),
				"bookingdates.checkin",Matchers.equalTo("2015-03-31"),
				"depositpaid",Matchers.equalTo(true));
	}
	
}
