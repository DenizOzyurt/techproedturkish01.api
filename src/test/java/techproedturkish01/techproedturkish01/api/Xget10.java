package techproedturkish01.techproedturkish01.api;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Xget10 extends TestBase {
	/*
	 When 
		 I send GET Request to URL http://dummy.restapiexample.com/api/v1/employees
	 Then
		 Status code is 200
		 1)Print all ids greater than 10 on the console
		   Assert that there are 14 ids greater than 10
		 2)Print all ages less than 30 on the console
		   Assert that maximum age is 23
		 3)Print all employee names whose salaries are greater than 350,000 
		   Assert that Charde Marshall is one of the employees whose salary is greater than 350,000
	 */
	
	@Test
	public void xget10() {
		Response response = given().spec(spec03).when().get();
	
		response.then().assertThat().statusCode(200);
		
		SoftAssert softassert=new SoftAssert();
		JsonPath json=response.jsonPath();
		
//		 1)Print all ids greater than 10 on the console
//		   Assert that there are 14 ids greater than 10
		
		List<String> idList=json.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
		System.out.println(idList);
		softassert.assertEquals(idList.size(), 14);
		
//		 2)Print all ages less than 30 on the console
//		   Assert that maximum age is 23
		
		List<String> ageList=json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
		System.out.println(ageList);
		
		Collections.sort(ageList);
		
		List<Integer> ageInt=new ArrayList<>();
		for(String a:ageList) {
			ageInt.add(Integer.valueOf(a));
		}
		System.out.println(ageList);
		softassert.assertTrue(ageInt.get(ageInt.size()-1)==23);
		
//		 3)Print all employee names whose salaries are greater than 350,000 
//		   Assert that Charde Marshall is one of the employees whose salary is greater than 350,000
		List<String> nameList = json.getList("data.findAll{Integer.valueOf(it.employee_salary)>350000}.employee_name");
			System.out.println(nameList);
			softassert.assertTrue(nameList.contains("Charde Marshall"));
	}
}
