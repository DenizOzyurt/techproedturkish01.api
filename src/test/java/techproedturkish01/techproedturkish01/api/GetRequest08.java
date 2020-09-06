package techproedturkish01.techproedturkish01.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequest08 extends TestBase {

	/*
	 1)We will print all employee names on the console
	  2)We will print the 3 rd employee names on the console
	 2)We will print first 5 employee names on the console
	 4)We will name of the last employee on the console
	 */
	
	@Test
	public void get01() {
		Response response =given().accept(ContentType.JSON).spec(spec03).get();
		response.prettyPrint();
		
	JsonPath json=response.jsonPath();
	//1)We will print all employee names on the console
	System.out.println(json.getString("data.employee_name"));
	//Assert that there are 24 employers
	//assertEquals(json.getString("data.employee_name").length(),Matchers.equalTo(352));
	
	/*
	 1)Hard Assertion : When the test fails , 
	 it stops execution and create error message(Assertion)
	 2)Soft Assertion : When the test fails , it runs the next tests as well, at the end it creates 
	 report for every assertions.(Verification)
	 */
	
	/*
	 To use Soft Assertion there are 3 steps :
	 1)Create an object from SoftAssert class==> SoftAssert =new SoftAssert();
	 2)By using softAssrt object use assertion methods
	 3) At the end HAVE TO use softAssert.assertAll()
	 */
	
	
	//  2)We will print the 3 rd employee names on the console
	System.out.println(json.getString("data.employee_name[2]"));	
	System.out.println(json.getString("data[2].employee_name"));
	
	//Assert the name of the 2rd employee if it is Ashton Cox
	SoftAssert softAssert=new SoftAssert();
	softAssert.assertEquals(json.getString("data[2].employee_name"), "Ashton Cox");
	
	
	//3)We will print first 5 employee names on the console
	System.out.println(json.getString("data[0,1,2,3,4].employee_name"));
	
	 //4)We will name of the last employee on the console
	// for find last data , use -1
	System.out.println(json.getString("data[-1].employee_name"));
	//Assert the name of the last employee Doris Wilder
	softAssert.assertEquals(json.getString("data[-1].employee_name"), "Doris Wilder");
	
	softAssert.assertAll();
	}
}
