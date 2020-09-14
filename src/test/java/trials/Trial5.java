package trials;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import techproedturkish01.techproedturkish01.api.TestBase2;

public class Trial5 extends TestBase2 {

//	  1)Create a class whose name is "GetRequest05" under src/test/java
//2)When I send a GET request to REST API URL 
//	 https://jsonplaceholder.typicode.com/todos/123
//Then HTTP Status Code should be 200
//And "Server" in Headers should be "cloudflare"
//And response content type is “application/JSON”
//And "userId" should be 7,
//And "title" should be "esse et quis iste est earum aut impedit"
//	 And "completed" should be false (edited) 
	
	@Test
	public void trial5() {
		spec3.pathParam("todos", 123);
		Response response = given().spec(spec3).when().get("/{todos}");
		response.prettyPrint();
		
		response.then().assertThat().statusCode(200).header("Server", "cloudflare").contentType(ContentType.JSON).
						body("userId",Matchers.equalTo(7),
								"title",Matchers.equalTo("esse et quis iste est earum aut impedit"),
								"completed",Matchers.equalTo(false));		
		
		
	}
}
