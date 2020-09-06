package techproedturkish01.techproedturkish01.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class Xget08 extends TestBase {

	/*
	 1)We will print all employee names on the console
	  2)We will print the 3 rd employee names on the console
	 2)We will print first 5 employee names on the console
	 4)We will name of the last employee on the console
	 */
	
	@Test
	public void xget08() {
		Response response=given().accept(ContentType.JSON).spec(spec03).when().get();
//		response.prettyPrint();
		
		JsonPath json=response.jsonPath();
		
		//json.prettyPrint();
		System.out.println(json.getList("data.employee_name"));
		System.out.println(json.getString("data[2].employee_name"));
		System.out.println(json.getString("data[0,1,2,3,4].employee_name"));
		System.out.println(json.getString("data[-1].employee_name"));
		
		//Assert that there are 24 employers
//		System.out.println(json.getList("data.employee_name").size());
		assertEquals(24,json.getList("data.employee_name").size());
		
		SoftAssert softassert=new SoftAssert();
	
		
		softassert.assertEquals(json.getString("data[-1].employee_name"), "Doris Wilder");
		softassert.assertEquals(json.getString("data[0].employee_name"), "Tiger Nixon");
		softassert.assertEquals(json.getString("data[4].employee_name"), "Airi Satou");
		softassert.assertAll();
	}
}
