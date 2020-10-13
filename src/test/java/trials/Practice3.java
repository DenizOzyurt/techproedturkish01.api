package trials;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import techproedturkish01.techproedturkish01.api.TestBase;

public class Practice3 extends TestBase{

	@Test
	public void practice3() {

//	When 
//		I send a GET request to REST API URL 
//		http://dummy.restapiexample.com/api/v1/employee/3
//	    Note: For Base URL use spec04
		spec04.pathParams("pathType","employee","id",3);
		Response response=given().spec(spec04).when().get("/{pathType}/{id}");
		response.prettyPrint();	
	
//      Note: For expected data use JSONObject
		JSONObject expR=new JSONObject();
		expR.put("employee_name", "Ashton Cox");
		expR.put("employee_salary", 86000);
		expR.put("employee_age",66);
		expR.put("format", "application/json");
		
//	    Then 
//	    HTTP Status Code should be 200
//	    And Response format should be "application/json"
//	    And "employee_name" should be "Ashton Cox"
//	    And "employee_salary" should be 86000
//	    And "employee_age" should be 66
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
				.body("data.employee_name", Matchers.equalTo(expR.getString("employee_name")),
					"data.employee_salary",Matchers.equalTo(expR.getInt("employee_salary")),
					"data.employee_age",Matchers.comparesEqualTo(expR.getInt("employee_age")))
				.header("Content-Type", Matchers.equalTo(expR.getString("format")));
	
//	    Note: For actual data use JsonPath
		
		JsonPath jsonBody=response.jsonPath();
		SoftAssert SA=new SoftAssert();
		SA.assertEquals(jsonBody.getString("data.employee_name"), expR.getString("employee_name"));
		SA.assertEquals(jsonBody.getInt("data.employee_salary"), expR.getInt("employee_salary"));
		SA.assertEquals(jsonBody.getInt("data.employee_age"), expR.getInt("employee_age"));
		SA.assertEquals(response.header("Content-Type"), expR.getString("format"));
		
		SA.assertAll();

	
}
}
