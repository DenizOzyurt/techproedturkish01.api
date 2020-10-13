package techproedturkish01.techproedturkish01.api;

	
	import static io.restassured.RestAssured.given;
	
	import java.util.HashMap;
	import java.util.Map;
	
	import org.hamcrest.Matchers;
	import org.junit.Test;
	
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	
	
	public class PostRequest05 extends TestBase {
			/*
				  					Warm Up (10 Minutes)
				 1)Create a spec object in TestBase class for the base url
				  "http://dummy.restapiexample.com/api/v1"
				 2)Add path parameter which is "/create" to the base url
				 3)By using Map, create a Request Body which has the following data
				   				{
							        "name": "Test Data",
							        "salary": "8888",
							        "age": "33"
			                    }
				 4)When 
				     I send POST Request to http://dummy.restapiexample.com/api/v1/create
				   Then 
				     Status code is 200
				     Content Type is "application/json"
				     "status" key has value "success"
				     "message" key has value "Successfully! Record has been added."  
				 5)Make assertions by using hard assertion     
		    */
		
		@Test
		public void post01() {
			spec04.pathParam("pathCreate", "create");
			
			Map<String, String> reqBody = new HashMap<>();
			reqBody.put("name", "Test Data");
			reqBody.put("salary", "8888");
			reqBody.put("age", "33");
			
			
			Response response = given().spec(spec04).body(reqBody).when().post("/{pathCreate}");
			response.prettyPrint();
			
			response.
			     then().
			     assertThat().
			     statusCode(200).
			     contentType(ContentType.JSON).
			     body("status", Matchers.equalTo("success"),
			          "message", Matchers.equalTo("Successfully! Record has been added."));
			
		}
		
	
	}	


