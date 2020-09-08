package techproedturkish01.techproedturkish01.api;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequest10 extends TestBase{

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
	public void get01() {
		Response response = given().
				               spec(spec03).
				            when().
				               get();
		response.prettyPrint();
		
		//Everytime for status code use hard assertion
		response.
		     then().
		     assertThat().
		     statusCode(200);
		
		//For the others we will use soft assertion with JsonPath
		JsonPath json = response.jsonPath();
		SoftAssert softAssert = new SoftAssert();
		
		//1)Print all ids greater than 10 on the console
		List<String> idList = json.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
		System.out.println(idList);
		//Assert that there are 14 ids greater than 10
		softAssert.assertEquals(idList.size(), 14);
		
		//2)Print all ages less than 30 on the console
		List<String> ageList = json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
		System.out.println(ageList);
		//Assert that maximum age is 23
		//a)Create a list to store integer ages
		List<Integer> ageListInt = new ArrayList<>();
		//b)By using for each loop I converted all String ages to Integer ages
		for(String w : ageList) {
			ageListInt.add(Integer.valueOf(w));
		}
		System.out.println(ageListInt);
		//c)I sorted the elements to make the greatest one the last element
		Collections.sort(ageListInt);
		System.out.println(ageListInt);
		//d)I used assertTrue to check if the last element is 23
		softAssert.assertTrue(ageListInt.get(ageListInt.size()-1)==23);
		
		//3)Print all employee names whose salaries are greater than 350,000
		List<String> nameList = json.getList("data.findAll{Integer.valueOf(it.employee_salary)>350000}.employee_name");
		System.out.println(nameList);
		//Assert that Charde Marshall is one of the employees whose salary is greater than 350,000
		softAssert.assertTrue(nameList.contains("Charde Marshall"));
		softAssert.assertAll();

	}
}
