package trials;

import static io.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import techproedturkish01.techproedturkish01.api.TestBase2;

public class Trial12 extends TestBase2 {


	/*         
    Warm Up (10 Minutes)
1)Create a class and name it as GetRequest12
2)When 
I send a GET Request to http://dummy.restapiexample.com/api/v1/employees
Then 
Status code is 200 (Use Hard Assertion)
And The names of first 5 employees are Tiger Nixon, Garrett Winters,
Ashton Cox, Cedric Kelly, Airi Satou (Use Soft Assertion)   
*/
	@Test
	public void trial12() {
		Response response=given().spec(spec2).when().get(); 
		response.prettyPrint();
		
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
		body("data.employee_name",Matchers.hasItems("Tiger Nixon","Garrett Winters","Ashton Cox","Cedric Kelly","Airi Satou"));
		
		//2.Way
		JsonPath json=response.jsonPath();
		List<String> namesAll=json.getList("data.employee_name");
		
		List<String> namesS=Arrays.asList("Tiger Nixon","Garrett Winters","Ashton Cox","Cedric Kelly","Airi Satou");
		
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(namesAll.containsAll(namesS));
		
		//3.Way
		List<Map> allM=json.getList("data");
		System.out.println(allM);
		
		for(int i=0;i<namesS.size();i++) {
			sa.assertEquals(namesS.get(i), allM.get(i).get("employee_name"));
		}
	}
	
}
