package techproedturkish01.techproedturkish01.api;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class Pojo02 extends TestBase{

	/*
		Warm Up (10 Minutes)
1)Create a spec object in TestBase class for the base url
"http://dummy.restapiexample.com/api/v1"
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
	public void pojo2() {
		TestPojo2 nInf= new TestPojo2("Veli", "999", "33");
		nInf.setStatus("success");
		nInf.setMessage("Successfully! Record has been added.");
		
		
		spec04.pathParam("createParam1", "create");
		Response response=given().spec(spec04).body(nInf).when().post("/{createParam1}");
		
		response.prettyPrint();
		
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
		
		Map<String,String> map = response.as(HashMap.class);
		
		SoftAssert sa= new SoftAssert();
		
		sa.assertEquals(map.get("status"), nInf.getStatus());
		sa.assertEquals(map.get("message"), nInf.getMessage());
	//	sa.assertEquals(map.get("name"), nInf.getName());
		
		sa.assertAll();
		
		
		
		
	}
	
	
}
