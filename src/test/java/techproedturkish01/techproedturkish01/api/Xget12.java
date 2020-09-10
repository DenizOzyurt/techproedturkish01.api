package techproedturkish01.techproedturkish01.api;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Xget12 extends TestBase  {

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
public void warmup() {
	Response response = given().spec(spec03).get(); 
//	response.prettyPrint();
	
	//1.Way
	response.then().assertThat().statusCode(200).
					body("data[0].employee_name", Matchers.comparesEqualTo("Tiger Nixon"),
							"data[1].employee_name", Matchers.comparesEqualTo("Garrett Winters"),
							"data[2].employee_name", Matchers.comparesEqualTo("Ashton Cox"),
							"data[3].employee_name", Matchers.comparesEqualTo("Cedric Kelly"),
							"data[4].employee_name", Matchers.comparesEqualTo("Airi Satou")
			);
	
	
	//2.Way
	JsonPath json=response.jsonPath();
	SoftAssert softassert=new SoftAssert();
	List<Map> allInf=json.getList("data");
	System.out.println(allInf);
	
	List<String> first5names=new ArrayList<>();
	first5names.add("Tiger Nixon");
	first5names.add("Garrett Winters");
	first5names.add("Ashton Cox");
	first5names.add("Cedric Kelly");
	first5names.add("Airi Satou");
	
	for(int i=0;i<first5names.size();i++) {
		softassert.assertEquals(allInf.get(i).get("employee_name"), first5names.get(i));
		
	}
	
	
	//3.Way
	
	List<String> allNameL=json.getList("data.employee_name");
	for(int i=0; i<first5names.size(); i++) {
		softassert.assertEquals(json.getString("data["+i+"].employee_name"), first5names.get(i));
	}
	
	softassert.assertAll();
	
	}

}
