package techproedturkish01.techproedturkish01.api;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.JsonUtil;


public class ObjectMapperPractice extends TestBase {

	/*
	1)Use spec01 and get method to get json response
	2)Convert Json to Java By using ObjectMapper
	3)Type hard assertion for status code
	4) Type soft assertions for response body detail 
	 */
	
	@Test
	public void getSpec01() {
		
		spec01.pathParam("id", 4);
		Response response=given().spec(spec01).when().get("/{id}");
		response.prettyPrint();
		
//		JsonPath json=response.jsonPath();
		
		Map<String,Object> actualMap=JsonUtil.convertJsonToJava(response.asString(), Map.class);
		System.out.println(actualMap);
		
		Map<String,Object> expectedMap=new HashMap<>();
		expectedMap.put("title","et porro tempora");
		expectedMap.put("completed",true);
		
		response.then().assertThat().statusCode(200);
		SoftAssert sa=new SoftAssert();
		
		sa.assertEquals(actualMap.get("title"), expectedMap.get("title"));
		sa.assertEquals(actualMap.get("completed"), expectedMap.get("completed"));
		
		
		
		
	}

}
