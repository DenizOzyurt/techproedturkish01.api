package techproedturkish01.techproedturkish01.api;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class PostReQuest04 extends TestBase{
	
	/*
	 {
            "id": "17",
            "employee_name": "Paul Byrd",
            "employee_salary": "725000",
            "employee_age": "64",
            "profile_image": ""
}	 */
	
	@Test
	public void pos01() {
		
		JSONObject reqBody=new JSONObject();
		reqBody.put("id", "17");
		reqBody.put("employee_name", "Paul Byrd");
		reqBody.put("employee_salary", "725000");
		reqBody.put("employee_age", "64");
		reqBody.put("profile_image", "");
		
		Response response=given().
				spec(spec03).
				body(reqBody).
				when().
				post();
		
		response.prettyPrint();
		
		response.
		     then().
		     assertThat().
		     statusCode(405);

	}

}
