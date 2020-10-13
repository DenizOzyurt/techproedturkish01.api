package techproedturkish01.techproedturkish01.api;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class Delete01 extends TestBase {
/*
 For Delete Request we need just EndPoint like Get Request
 */
	
	@Test
	public void delete01() {
		
		//Get the data before deleting
		Response response=given().spec(spec01).when().get("/198");
		response.prettyPrint();
		
		Response responseDel=given().spec(spec01).when().delete("/196");
		responseDel.prettyPrint();
		
	}
}
