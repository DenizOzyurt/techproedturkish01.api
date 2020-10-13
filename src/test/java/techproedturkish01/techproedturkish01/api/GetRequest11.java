package techproedturkish01.techproedturkish01.api;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.Gson;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

public class GetRequest11 extends TestBase {
	
	//GSON is a converter 
	//By using GSON we can convert Json Data to Java Object ==>DE-Serialization
	// or           we can convert Java object to Json Data ==>Serialization
	
	
//"https://jsonplaceholder.typicode.com/todos/2"
	//Assert that "completed" is false by using soft assertion
	//Assert that "title" is "quis ut nam facilis et officia qui" by using soft assertion
	//How to convert Java Object to Json Data ==> Serialization
	
		@Test
		public void get01() {
			
			spec01.pathParam("id", 2);
			
			Response response = given().
					               spec(spec01).
					            when().
					               get("/{id}");
			response.prettyPrint();
			
			HashMap<String,Object> map = response.as(HashMap.class);//De-Serialization
			
			System.out.println(map);
			System.out.println(map.keySet());
			System.out.println(map.values());
			
			SoftAssert softAssert = new SoftAssert();
			
			//Assert that "completed" is false by using soft assertion
			softAssert.assertEquals(map.get("completed"), false);
			//Or
			softAssert.assertTrue(map.get("completed").equals(false));
			
			//Assert that "title" is "quis ut nam facilis et officia qui" by using soft assertion
			softAssert.assertEquals(map.get("title"),"quis ut nam facilis et officia qui");
			
			//Assert that "userId" is 1 by using soft assertion
			softAssert.assertEquals(map.get("userId"),1);
			
			softAssert.assertAll();
			
			//How to convert Java Object to Json Data ==> Serialization
			Gson gson = new Gson();
			
			String jsonToMap=gson.toJson(map);
			
			System.out.println(gson.toJson(map));
	
		}

}
