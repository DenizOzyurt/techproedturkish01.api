package trials;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import techproedturkish01.techproedturkish01.api.TestBase;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Review2 extends TestBase {

//	When 
//	I send a POST request to REST API URL 
//	http://dummy.restapiexample.com/api/v1/create
@Test
public void review2() {
	Response response=given().spec(spec03).when().get();
	response.prettyPrint();
	
	JsonPath json=response.jsonPath();
	List<String> ages=json.getList("data.employee_age");
	System.out.println(ages);
	
	List<String> ages1=json.getList("data.findAll{Integer.valueOf(it.employee_age)<=35}.employee_age");
	List<Integer> ageInt=new ArrayList<>();
	System.out.println(ages1);
	for(int i=0;i<ages1.size();i++) {
		ageInt.add(Integer.valueOf(ages1.get(i)));
	}
	
	
	
	
	
}
	
	
	
}
