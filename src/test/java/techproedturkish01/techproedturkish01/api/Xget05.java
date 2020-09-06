package techproedturkish01.techproedturkish01.api;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Xget05 {

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
	public void xget05() {
		Response response=given()
				.when().get("https://jsonplaceholder.typicode.com/todos/123");
		response.prettyPrint();
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON).header("Server", "cloudflare").
		body("userId", Matchers.equalTo(7),"title",Matchers.equalTo("esse et quis iste est earum aut impedit"));
		assertEquals(true,response.asString().contains("false"));
	
	}
}
