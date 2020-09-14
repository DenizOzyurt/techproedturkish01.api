package trials;

import org.junit.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.List;

import techproedturkish01.techproedturkish01.api.TestBase2;

public class trial8 extends TestBase2 {

	/*
	 1)We will print all employee names on the console
	  2)We will print the 3 rd employee names on the console
	 2)We will print first 5 employee names on the console
	 4)We will name of the last employee on the console
	 */
	@Test
	public void trial8() {
		
		Response response = given().spec(spec2).when().get();
		
		response.then().assertThat().statusCode(200);
		response.prettyPrint();
		JsonPath json=response.jsonPath();
		
		List<String> names=json.getList("data.employee_name");
		System.out.println(names);
		System.out.println(json.getString("data[2].employee_name"));
		System.out.println(names.get(names.size()-1));
		
		
		
	}
	
}
