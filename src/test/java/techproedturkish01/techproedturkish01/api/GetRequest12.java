package techproedturkish01.techproedturkish01.api;


import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class GetRequest12  extends TestBase  {
	
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
		public void get01() {
			
			Response response = given().
					               spec(spec03).
					            when().
					               get();
			response.prettyPrint();
			
			response.
			     then().
			     assertThat().
			     statusCode(200);
			
			JsonPath json = response.jsonPath();
			SoftAssert softAssert = new SoftAssert();
			
			//1.Way:Not recommended
			softAssert.assertEquals(json.getString("data[0].employee_name"), "Tiger Nixon");
			softAssert.assertEquals(json.getString("data[1].employee_name"), "Garrett Winters");
			softAssert.assertEquals(json.getString("data[2].employee_name"), "Ashton Cox");
			softAssert.assertEquals(json.getString("data[3].employee_name"), "Cedric Kelly");
			softAssert.assertEquals(json.getString("data[4].employee_name"), "Airi Satou");
			
			//2.Way: Can be used
			List<String> nameList = new ArrayList<>();
			nameList.add("Tiger Nixon");
			nameList.add("Garrett Winters");
			nameList.add("Ashton Cox");
			nameList.add("Cedric Kelly");
			nameList.add("Airi Satou");
			for(int i=0; i<nameList.size(); i++) {
				softAssert.assertEquals(json.getString("data[" + i + "].employee_name"), nameList.get(i));
			}
			
			//3.Way:The best to use
			List<Map> actualList = json.getList("data");
			System.out.println(actualList);
			
			Map<Integer,String> expectedMap = new HashMap<>();
			expectedMap.put(0, "Tiger Nixon");
			expectedMap.put(1, "Garrett Winters");
			expectedMap.put(2, "Ashton Cox");
			expectedMap.put(3, "Cedric Kelly");
			expectedMap.put(4, "Airi Satou");
			
			for(int i=0; i<expectedMap.size(); i++) {
				softAssert.assertEquals(actualList.get(i).get("employee_name"), expectedMap.get(i));
			}
	
			softAssert.assertAll();

	}

}
