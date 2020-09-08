package techproedturkish01.techproedturkish01.api;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class GetRequest09 extends TestBase {
	
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
	public void get01() {
		
		Response response = given().
				               spec(spec03).
				            when().
				               get();
		response.prettyPrint();
		
		//Hard Assertion
		response.
		     then().
		     assertThat().
		     statusCode(200).
		     body("data[4].employee_name", equalTo("Airi Satou"),
		    	  "data[5].employee_salary", equalTo("372000"),
		    	  "data.id",hasSize(24),
		    	  "data.employee_name", hasItem("Rhona Davidson"),
		    	  "data.employee_age", hasItems("21", "23", "61"));
		
		/*
		 JsonPath is used to navigate inside a Json Data easily
		*/
		
		//Soft Assertion and JsonPath
		JsonPath json = response.jsonPath();
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(json.getString("data[4].employee_name"), "Airi Satou");
		softAssert.assertEquals(json.getString("data[5].employee_salary"), "372000");
		softAssert.assertEquals(json.getList("data.id").size(), 24);
		softAssert.assertTrue(json.getList("data.employee_name").contains("Rhona Davidson"));
		
		List<String> ages = new ArrayList<>();
		ages.add("21");
		ages.add("23");
		ages.add("61");
	    softAssert.assertTrue(json.getList("data.employee_age").containsAll(ages));
		
		softAssert.assertAll();

	}
}
