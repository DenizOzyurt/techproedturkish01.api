package techproedturkish01.techproedturkish01.api;



import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;
import utilities.JsonUtil;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class ObjectMapperWithMap extends TestBase {
	
	@Test
	public void javaToJson() {
	HashMap<Integer, String > map= new HashMap<>();
	map.put(101, "Ali");
	map.put(102, "Veli");
	map.put(103, "Angie");
	map.put(104, "Marry");
	System.out.println(map);
	
	String jsonFromMap = JsonUtil.convertJavaToJson(map);
	System.out.println(jsonFromMap);
	
//	String reqBody="{\r\n" + 
//			"    \"bookingid\": 24,\r\n" + 
//			"    \"booking\": {\r\n" + 
//			"        \"firstname\": \"Veli\",\r\n" + 
//			"        \"lastname\": \"Can\",\r\n" + 
//			"        \"totalprice\": 333,\r\n" + 
//			"        \"depositpaid\": true,\r\n" + 
//			"        \"bookingdates\": {\r\n" + 
//			"            \"checkin\": \"2020-10-20\",\r\n" + 
//			"            \"checkout\": \"2020-11-04\"\r\n" + 
//			"        },\r\n" + 
//			"        \"additionalneeds\": \"Breakfast\"\r\n" + 
//			"    }\r\n" + 
//			"}";
	
//	Map<Integer,String> JavaFromJson=JsonUtil.convertJsonToJava(reqBody, Map.class);
//	
//	String trial1="{\"ali\":24}";
//	Map<Integer,String> JavaFromJson=JsonUtil.convertJsonToJava(trial1, Map.class);

	Map<Integer,String> JavaFromJson=JsonUtil.convertJsonToJava(jsonFromMap, Map.class);
	System.out.println(JavaFromJson);
	
	
	}
	
	@Test
	public void jsonFromApiToJava() {
		spec02.pathParam("id", 3);
		
		Response response=given().spec(spec02).when().get("/{id}");
		response.prettyPrint();
		
		Map<String, Object> apiJsonToMap= JsonUtil.convertJsonToJava(response.asString(), Map.class);
		System.out.println(apiJsonToMap);
		
		Map<String, Object> expectedValueMap=new HashMap<>();
		expectedValueMap.put("firtname", "Eric");
		expectedValueMap.put("lastname", "Jackson");
		expectedValueMap.put("totalprice", 107);
		expectedValueMap.put("depositpaid", false);
		
		response.then().assertThat().statusCode(200);
		assertEquals(expectedValueMap.get("firtname"),apiJsonToMap.get("firstname"));
		assertEquals(expectedValueMap.get("lastname"),apiJsonToMap.get("lastname"));
		
		SoftAssert sA=new SoftAssert();
		
		sA.assertEquals(apiJsonToMap.get("firtname"), expectedValueMap.get("firstname"));
		sA.assertEquals(apiJsonToMap.get("lastname"), expectedValueMap.get("lastname"));
		sA.assertEquals(apiJsonToMap.get("totalprice"), expectedValueMap.get("totalprice"));
		sA.assertEquals(apiJsonToMap.get("depositpaid"), expectedValueMap.get("depositpaid"));
		
		
		
		
	}
	
}
