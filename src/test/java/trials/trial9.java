package trials;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import techproedturkish01.techproedturkish01.api.TestBase2;

import static io.restassured.RestAssured.given;

public class trial9 extends TestBase2 {

	/*         
		 				Warm Up (10 Minutes)
		 1)Create a class and name it as GetRequest09
		 2)When 
		 	 I send a GET Request to http://dummy.restapiexample.com/api/v1/employees
		 Then 
			 status code is 200
			 And the name of the 5th employee is "Airi Satou"
			 And the salary of the 6th employee is "372000"
			 And there are "24" employees
			 And "Rhona Davidson" is one of the employees
			 And "21", "23", "61" are among the employee ages
		 3)Do the assertions by using Hard Assertion	 
	*/
	
	@Test
	public void trial9() {
		Response response = given().spec(spec2).when().get();
		
		response.then().assertThat().statusCode(200);
		
		JsonPath json = response.jsonPath();
		assertEquals(json.getString("data[4].employee_name"),"Airi Satou");
		assertEquals(json.getString("data[4].employee_salary"),"162700");
		assertEquals(json.getList("data.employee_salary").size(),24);
		assertTrue(json.getString("data.employee_name").contains("Rhona Davidson"));
		List<String> nm=Arrays.asList("21","23","61");
		
		assertTrue(json.getList("data.employee_age").containsAll(nm));
		
		
		
		
		
		
		
		
	}
}
