package trials;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import techproedturkish01.techproedturkish01.api.TestBase2;

public class trial10 extends TestBase2 {

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
	public void trial10() {
		Response response=given().spec(spec2).when().get();
		
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
//		response.prettyPrint();
		
		SoftAssert softassert=new SoftAssert();
		JsonPath json=response.jsonPath();
		
//		List<String> agesAll=json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
		List<String> ageList=json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
		System.out.println(ageList);
		
		List<Integer> agesI=new ArrayList<>();
		for(String w:ageList) {
			agesI.add(Integer.valueOf(w));
		}
		Collections.sort(agesI);
		
		softassert.assertTrue( agesI.get(agesI.size()-1)==23);
		
//		3)Print all employee names whose salaries are greater than 350,000 
//		   Assert that Charde Marshall is one of the employees whose salary is greater than 350,000
		
		List<String> nameL=json.getList("data.findAll{Integer.valueOf(it.employee_salary)>350000}.employee_name");
		System.out.println(nameL);
		softassert.assertTrue(nameL.contains("Charde Marshall"));
		
		
		
		softassert.assertAll();
		
	}
	
}
