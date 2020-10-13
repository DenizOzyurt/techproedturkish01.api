package trials;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import techproedturkish01.techproedturkish01.api.Booking;
import techproedturkish01.techproedturkish01.api.Bookingdates;
import techproedturkish01.techproedturkish01.api.TestBase;
import techproedturkish01.techproedturkish01.api.Trpojo1;
import techproedturkish01.techproedturkish01.api.Trpojo11;

import static io.restassured.RestAssured.*;

public class TrPojo1 extends TestBase {
	/*
	1)Create a spec object in TestBase class for the base url
	"http://dummy.restapiexample.com/api/v1"
	2)Add path parameter which is "/create" to the base url
	3)By using POJO, create a Request Body which has the following data
{
    "firstname": "Jim",
    "lastname": "Ericsson",
    "totalprice": 562,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2019-04-10",
        "checkout": "2020-02-23"
    },
    "additionalneeds": "Breakfast"
}
	4)When 
	I send POST Request to spec02
	Then 
	Status code is 200
	Content Type is "application/json"
	"status" key has value "success"
	"message" key has value "Successfully! Record has been added."  
	5)Make assertions by using hard assertion     
	*/		
	@Test 
	public void testPojo() {
		Response response=given().spec(spec02).when().get("/28");
		response.prettyPrint();
	
		Bookingdates bookingdates = new Bookingdates("2020-09-15", "2020-09-17");
		Booking booking = new Booking("Ali", "Can", 999, true, bookingdates, "Wifi");
		
		response=given().contentType(ContentType.JSON).
				spec(spec02).body(booking).when().post();
		
		response.prettyPrint();
		response.then().assertThat().
		statusCode(200).contentType(ContentType.JSON);
		
		
		
		
		
		
		
		
	}
	
	
}
