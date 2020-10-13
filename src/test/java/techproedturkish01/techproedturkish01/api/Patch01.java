package techproedturkish01.techproedturkish01.api;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class Patch01 extends TestBase {

	/*
	 For Patch Request we need;
	 1)Endpoint
	 2)Partial or Full(Not meaningful because for full we use PUT) Request Body
	*/
	
	@Test
	public void patch01() {
		
		//1)I will get a data before updating
		Response response = given().
				               spec(spec01).
				            when().
				               get("/200");
		response.prettyPrint();
		
		//2)I will update the data
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("title", "Suleyman Alptekin");
		
		Response putResponse = given().
				                   accept(ContentType.JSON).
				                   spec(spec01).
				                   body(reqBody.toString()).
				               when().
				                   patch("/200");
		putResponse.prettyPrint();
		
		//Assert the status code
		response.
		     then().
		     assertThat().
		     statusCode(200);
	
	}
}
