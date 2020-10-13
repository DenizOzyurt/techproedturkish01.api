package techproedturkish01.techproedturkish01.api;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.JsonUtil;

public class Practice1 extends TestBase {

	@Test
	public void practice1() {
		
		spec02.pathParam("id", 1001);
		Response response=given().spec(spec02).when().get("/{id}");
		response.prettyPrint();
		
		response.then().assertThat().statusCode(404);
		
		SoftAssert SA=new SoftAssert();
		
		
		Map<String,Object> map=JsonUtil.convertJsonToJava(response.asString(), Map.class);
		
		SA.assertTrue(map.containsValue("Not Found"));
		SA.assertTrue(!map.containsValue("Java API"));
		
		
		
		
		
		
	}
	
}
