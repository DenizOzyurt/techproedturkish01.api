package techproedturkish01.techproedturkish01.api;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class XgetREquest09 extends TestBase {
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
	public void test09() {
		Response response=given().spec(spec03).when().get();
		response.prettyPrint();
		
		response.then().assertThat().statusCode(200).
		body("data[4].employee_name", Matchers.equalTo("Airi Satou"),
				"data[5].employee_salary",Matchers.equalTo("372000"),
				"data.id",Matchers.hasSize(24),
				"data.employee_age",Matchers.hasItems("21","23","61")
				);
		
	}
	@Test
	public void test09json() {
		Response response =given().spec(spec03).when().get();
		
		JsonPath json=response.jsonPath();
		SoftAssert softass=new SoftAssert();
		
//		And the name of the 5th employee is "Airi Satou"
//		And the salary of the 6th employee is "372000"
//		And there are "24" employees
//		And "Rhona Davidson" is one of the employees
//		And "21", "23", "61" are among the employee ages
		
		softass.assertEquals(json.getString("data[4].employee_name"), "Airi Satou");
		softass.assertEquals(json.getString("data[5].employee_salary"), "372000");
		softass.assertEquals(json.getList("data.id"), 24);
		softass.assertTrue(json.getList("data.employee_name").contains("Rhona Davidson"));
		List<String> ageList=new ArrayList<>();
		ageList.add("21");
		ageList.add("23");
		ageList.add("61");
		softass.assertTrue(json.getList("data.employee_age").containsAll(ageList));
		
	}
}
