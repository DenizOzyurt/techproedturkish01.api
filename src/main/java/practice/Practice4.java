package practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import techproedturkish01.techproedturkish01.api.Practice4pojo;
import techproedturkish01.techproedturkish01.api.TestBase;

public class Practice4 extends TestBase{

	/*
	When 
	I send a POST request to REST API URL 
	http://dummy.restapiexample.com/api/v1/create
	{
	"employee_name": "Ali Can",
	"employee_salary": "77000",
	"employee_age": "35",
	"profile_image": ""
	}  
	Then 
	HTTP Status Code should be 200
	And Response format should be "application/json"
	And "employee_name" should be "Ali Can"
	And "employee_salary" should be 77000
	And "employee_age" should be 35
	And "profile_image" should be ""
	And "status" should be "success"
	And "message" should be "Successfully! Record has been added."​
	Note: For Base URL use spec04 and add path param "/create"
	Note: For actual data use De-Serialization
	Note: For expected data use Pojo Class
	Note: Use Hard Assertion and Soft Assertion
	*/
	

@Test
public void pojoPractice() {
	
	Practice4pojo team6=new Practice4pojo("Ali Can","99000","33",null);
	team6.setStatus("success");
	team6.setMessage("Successfully! Record has been added.");
	spec04.pathParam("need", "create");
	Response response=given().spec(spec04).contentType(ContentType.JSON).body(team6).when().post("/{need}");
	response.prettyPrint();
	
//	Then 
//	HTTP Status Code should be 200
//	And Response format should be "application/json"
//	And "employee_name" should be "Ali Can"
	
//	Note: For actual data use De-Serialization
//	Note: For expected data use Pojo Class
//	Note: Use Hard Assertion and Soft Assertion
//	Map<String,Object> actData=JsonUtil.convertJsonToJava(response.asString(), HashMap.class);

	
//	HTTP Status Code should be 200
//	And Response format should be "application/json"
//	And "employee_name" should be "Ali Can"
//	And "employee_salary" should be 99000
//	And "employee_age" should be 35
//	And "profile_image" should be ""
	
	response.then().assertThat().statusCode(200).
						contentType(ContentType.JSON).
						body("data.employeeName",equalTo(team6.getEmployeeName()),
								"data.employeeSalary",equalTo(team6.getEmployeeSalary()),
								"data.employeeAge",equalTo(team6.getEmployeeAge()),
								"data.profileImage",equalTo(team6.getProfileImage()),
								"status",equalTo(team6.getStatus()),
								"message",equalTo(team6.getMessage()));
										
	JsonPath actData=response.jsonPath();
	assertEquals(team6.getEmployeeName(),actData.get("data.employeeName"));
	assertEquals(team6.getEmployeeSalary(),actData.get("data.employeeSalary"));
	assertEquals(team6.getEmployeeAge(),actData.get("data.employeeAge"));
	assertEquals(team6.getProfileImage(),actData.get("data.profileImage"));
	
	SoftAssert SA=new SoftAssert();
	
	SA.assertEquals(actData.get("status"), team6.getStatus());
	SA.assertEquals(actData.get("data.employeeName"), team6.getEmployeeName());
	SA.assertEquals(actData.get("data.employeeSalary"), team6.getEmployeeSalary());
	SA.assertEquals(actData.get("data.employeeAge"), team6.getEmployeeAge());
	SA.assertEquals(actData.get("data.profileImage"), team6.getProfileImage());
	
	Map<String,String> actDataMap=response.as(HashMap.class);
	System.out.println(actDataMap);
	
	SA.assertTrue(actDataMap.get("data").toString().contains(team6.getEmployeeAge()));
	SA.assertTrue(actDataMap.get("data").toString().contains(team6.getEmployeeSalary()));
	
	
	SA.assertAll();
	//install jenkins
}






	
	
}
