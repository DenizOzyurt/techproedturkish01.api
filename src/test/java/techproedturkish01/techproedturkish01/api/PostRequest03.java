package techproedturkish01.techproedturkish01.api;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class PostRequest03 extends TestBase {
	/*
	 {
    "userId": 1,
    "id": 2,
    "title": "Aliiiiiii",
    "completed": false
}
	 */
	
	@Test
	public void post01() {
	JSONObject reqBody = new JSONObject();
	reqBody.put("userId",1);

	reqBody.put("title","Aliiiiiii");
	reqBody.put("userId",false);
	
	
	Response response=given().
						spec(spec01).accept(ContentType.JSON).
						body(reqBody).
						when().
						post();
	
	response.prettyPrint();

	response.then().
				assertThat().
				statusCode(201);}
	
	@Test
	public void get01() {
	Response response=given().
			spec(spec01).
			
			when().
			get("/10");

	response.prettyPrint();
	}
}