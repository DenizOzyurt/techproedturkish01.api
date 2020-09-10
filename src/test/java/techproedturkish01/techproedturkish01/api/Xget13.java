package techproedturkish01.techproedturkish01.api;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class Xget13 {

	
	


		//Assert that minumum age is 19
		//Assert that maximum salary is 725000
		
		@Test
		public void test12() {
		JsonPath json=new JsonPath(new File("C:\\Users\\Pc\\Desktop\\Employee.json"));
//		json.prettyPrint();
		
		SoftAssert soft=new SoftAssert(); 
				
		List<String> ages=json.getList("data.employee_age");
		List<Integer> agesInt=new ArrayList<>();
		
		for(int i=0;i<ages.size();i++) {
			agesInt.add(Integer.valueOf(ages.get(i)));
		}
		
		Collections.sort(agesInt);
		System.out.println(agesInt);
		soft.assertTrue(agesInt.get(0)==19);
		
		List<Map> allData=json.getList("data");
		System.out.println(allData);
		
		List<Integer> maxSal=new ArrayList<>();
		
		for(int i=0;i<allData.size();i++) {
		maxSal.add(Integer.valueOf((String) allData.get(i).get("employee_salary")));
		}
		
		Collections.sort(maxSal);
		System.out.println(maxSal);
		
		soft.assertTrue(maxSal.get(maxSal.size()-1)==725000);
		
		soft.assertAll();
	}

}
