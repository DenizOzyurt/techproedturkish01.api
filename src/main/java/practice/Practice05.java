package practice;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import techproedturkish01.techproedturkish01.api.Practice4pojo;
import techproedturkish01.techproedturkish01.api.TestBase;
import utilities.JsonUtil;

public class Practice05 extends TestBase {

	/*
	When 
	I send a PUT request to REST API URL 
	http://dummy.restapiexample.com/api/v1/update/21
	{
	"employee_name": "Veli Han",
	"employee_salary": "88000",
	"employee_age": "33",
	"profile_image": ""
	}  
	Then 
	HTTP Status Code should be 200
	And Response format should be "application/json"
	And "employee_name" should be "Ali Can"
	And "employee_salary" should be 77000
	And "employee_age" should be 35
	And "profile_image" should be ""
	Note: For Base URL use spec04 and add path param "/update/21"
	Note: For actual data use JsonPath
	Note: For expected data use JSONObject
	Note: Use Hard Assertion and Soft Assertion
	*/

	@Test
	public void practice05() {

		spec04.pathParams("version","update","id",13);
		
		//To create request body we have many options
		JSONObject putReqBody=new JSONObject();
		putReqBody.put("employee_name", "AliKacmaz");
		putReqBody.put("employee_salary", "44000");
		putReqBody.put("employee_age", "40");
		putReqBody.put("profile_image", "");
		
		JSONObject expectedReqBody=new JSONObject();
		expectedReqBody.put("status", "success");
		expectedReqBody.put("empty", false);
		expectedReqBody.put("message", "Successfully! Record has been updated.");
		
		Response response = given().
							contentType(ContentType.JSON).
							spec(spec04).
							body(putReqBody).
							when().
							put("/{version}/{id}");
		response.prettyPrint();
		
		//Assert with body()
		response.then().assertThat().statusCode(200).
									body("status",Matchers.equalTo(expectedReqBody.getString("status")),
										  "data.empty",Matchers.equalTo(expectedReqBody.getBoolean("empty")),
										  "message",Matchers.equalTo(expectedReqBody.getString("message")));
		
		//SoftAssertion 
		//JsonPAth   2)De-serilization c)GSON  d)Map
		SoftAssert SA=new SoftAssert();
		
		JsonPath json=response.jsonPath();
		
		SA.assertEquals(json.get("status"), expectedReqBody.getString("status"));
		SA.assertEquals(json.get("data.empty"), expectedReqBody.getBoolean("empty"));
		SA.assertEquals(json.get("message"), expectedReqBody.getString("message"));
		SA.assertAll();
	}







	
	
}
