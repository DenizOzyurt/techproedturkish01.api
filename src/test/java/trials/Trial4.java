


package trials;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import techproedturkish01.techproedturkish01.api.TestBase;
import techproedturkish01.techproedturkish01.api.TestBase2;

import static io.restassured.RestAssured.*;

public class Trial4 extends TestBase2 {

	/*
	 When I send a GET request to REST API URL
	 http://dummy.restapiexample.com/api/v1/employees
    And Accept type is “application/JSON”
    Then
    HTTP Status Code should be 200
    And Response format should be "application/JSON"
    And there should be 24 employees
    And "Ashton Cox" should be one of the employees
    And 21, 61, and 23 should be among the employee ages
	 */
	
	@Test
	public void trial4() {
		
		Response response=given().spec(spec2).when().accept(ContentType.JSON).get();
		response.prettyPrint();
		
		response.then().assertThat().
						statusCode(200).
						contentType(ContentType.JSON).
						body("data.id", Matchers.hasSize(24),
							"data.employee_name" , Matchers.hasItem("Ashton Cox"),
							"data.employee_age" ,Matchers.hasItems("21","61","23"));
		
		
	}
	
}
