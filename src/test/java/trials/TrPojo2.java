package trials;

import techproedturkish01.techproedturkish01.api.TestBase;
import techproedturkish01.techproedturkish01.api.Trpojo2;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class TrPojo2 extends TestBase {
	/*
2)Add path parameter which is "/create" to the base url
3)By using POJO, create a Request Body which has the following data
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
public void Tripost() {
	
	Trpojo2 trial2=new Trpojo2("sen","3000","40");
	trial2.setStatus("success");
	trial2.setMessage("Successfully! Record has been added.");
	
	spec04.pathParam("trail", "create");
	Response response=given().spec(spec04).when().post("/{trail}");
	response.prettyPrint();
	
	response.then().assertThat().
						statusCode(200).
						contentType(ContentType.JSON).
						body("status",equalTo("success"),
								"message",equalTo("Successfully! Record has been added.")
								);
	
	Map<String,Object> mapResponse=response.as(HashMap.class);
	SoftAssert SA=new SoftAssert();
	SA.assertEquals(mapResponse.get("status"), "success");
	SA.assertEquals(mapResponse.get("message"),"Successfully! Record has been added.");
	
	JsonPath jResponse=response.jsonPath();
	SA.assertEquals(jResponse.get("status"), trial2.getStatus());
	SA.assertEquals(jResponse.get("message"),trial2.getMessage());
	
	
	SA.assertAll();
	
	
	
	
	
}
	
}
