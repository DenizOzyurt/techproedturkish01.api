package trials;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.Gson;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import techproedturkish01.techproedturkish01.api.TestBase2;

public class Trial11 extends TestBase2 {

	//GSON is a converter 
	//By using GSON we can convert Json Data to Java Object ==>DE-Serialization
	// or           we can convert Java object to Json Data ==>Serialization
	
	
//"https://jsonplaceholder.typicode.com/todos/2"
	//Assert that "completed" is false by using soft assertion
	//Assert that "title" is "quis ut nam facilis et officia qui" by using soft assertion
	//How to convert Java Object to Json Data ==> Serialization
	
	@Test
	public void trial11() {
		
		spec3.pathParam("id",2);
		Response response=given().spec(spec3).when().get("/{id}");
		
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
		
		HashMap<String,Object> second=response.as(HashMap.class);
		System.out.println(second);
		SoftAssert soft=new SoftAssert();
		
		soft.assertEquals(second.get("completed"),false);
		soft.assertEquals(second.get("title"), "quis ut nam facilis et officia qui");
		
		Gson jsonM=new Gson();
		
		
				System.out.println(jsonM.toJson(second));
		 
	
				
		 
		 
		 
		
		
		
	}
	
}
