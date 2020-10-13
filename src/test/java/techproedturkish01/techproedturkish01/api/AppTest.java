package techproedturkish01.techproedturkish01.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestBase 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
	@Test
	public void get01() {
	
		Response response=given().
							accept("application/json").//it means API will only accept JSON format data.
						  when().
							  get("https://restful-booker.herokuapp.com/booking/3");
		response.prettyPrint();//prettyPrint() prints the response body on the console
		
		response.
			then().
			assertThat().
			statusCode(200).
			contentType("application/json").
			statusLine("HTTP/1.1 200 OK");
	}
	
	@Test
	public void get02() {
		spec02.pathParam("bookingid", 5);
		
		Response response=given().spec(spec02).when().get("/{bookingid}");
		response.prettyPrint();
		
		JsonPath json=response.jsonPath();
		System.out.println(json.getString("firstname"));
		assertEquals("First name is not as expected","Mark",json.getString("firstname"));
		
				
		System.out.println(json.getString("lastname"));
		assertEquals("Last name is not as expected","Smith",json.getString("lastname"));
		
		System.out.println(json.getInt("totalprice"));
		assertEquals("Prize is not as expected",698,json.getInt("totalprice"));
		
		System.out.println(json.getBoolean("depositpaid"));
		assertEquals("Depozit is not as expected",true,json.getBoolean("depositpaid"));
		
		System.out.println(json.getString("bookingdates.checkin"));
		assertEquals("CheckIn is not as expected","2020-08-06",json.getString("bookingdates.checkin"));
		
		System.out.println(json.getString("bookingdates.checkout"));
		assertEquals("CheckOut is not as expected","2020-08-17",json.getString("bookingdates.checkout"));
		
	}
	
	
	@Test
	public void get03() {
		
		Response response=given().
							accept(ContentType.JSON).
						when().
							get("http://dummy.restapiexample.com/api/v1/employees");
		response.prettyPrint();
	
		response.
			then().
			assertThat().
			statusCode(200).
			contentType(ContentType.JSON).
			body("data.id",hasSize(24),
				"data.employee_name",hasItem("Ashton Cox"),
				"data.employee_age",hasItems("21","61","23"));
	
	} 
	
	@Test
	public void test() {
		
		Response response = given().spec(spec02).pathParam("bookingid", 3).get("/{bookingid}");
		response.prettyPrint();
		
		Map<String,Object> map = new HashMap();
		map.put("firstname","Mary");
		map.put("totalprice",535);
		map.put("depositpaid",false);
		map.put("checkin","2019-07-10");
		
		response.then().assertThat().
			statusCode(200).
		contentType(ContentType.JSON).
			statusLine("HTTP/1.1 200 OK").
		body("firstname", Matchers.equalTo(map.get("firstname")),
				"bookingdates.checkin",Matchers.equalTo(map.get("checkin")),
				"depositpaid",Matchers.equalTo(map.get("depositpaid")));
	}
	
}
