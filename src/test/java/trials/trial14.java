package trials;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;

public class trial14 {

	@Test
	public void trial14() {
	
//		JsonPath json1 =new JsonPath( new File("‪C:\\Users\\Pc\\Desktop\\Employee.json"));
//		JsonPath json= new JsonPath( new File("C:\\Users\\Pc\\Desktop\\Employee.json")); //JsonPath const. do not work without parameter
	JsonPath json=new JsonPath( new File("C:\\Users\\Pc\\Desktop\\Employee.json")); 
		SoftAssert softassert=new SoftAssert();
		
		//Assert that maximum salary is 725000
		
		json.prettyPrint();
	}
	
}
