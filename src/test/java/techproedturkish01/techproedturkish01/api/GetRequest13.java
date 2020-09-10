package techproedturkish01.techproedturkish01.api;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;

public class GetRequest13 {

	//How to work with JsonData in our Local computer
	
	//We do not use ResrAssered library because we do not work with API, over here i will use our local depo
	@Test
	public void get01() {

		JsonPath json= new JsonPath( new File("C:\\Users\\Pc\\Desktop\\Employee.json")); //JsonPath const. do not work without parameter
		SoftAssert softassert=new SoftAssert();
		
		//Assert that maximum salary is 725000
		
		json.prettyPrint();
		
		List<String> salaryList=json.getList("data.employee_salary");
		System.out.println(salaryList);
		Collections.sort(salaryList);
	
		//DIKKAAAAT sort method put the 9 without looking number of digit. It is wrong.
		System.out.println(salaryList);
		
		List<Integer> salaryListInt=new ArrayList<>();
		for(String w:salaryList) {
			salaryListInt.add(Integer.valueOf(w));
		}
		
		System.out.println(salaryListInt);
		Collections.sort(salaryListInt);
		System.out.println(salaryListInt);
		
		softassert.assertTrue(salaryListInt.get(salaryListInt.size()-1)==725000);
		

		//Assert that minumum age is 19
//		List<String> ageList=json.getList("data.employee_salary");	
//		List<Integer> ageListInt=new ArrayList<>();
//		for(String w:salaryList) {
//			salaryListInt.add(Integer.valueOf(w));
//		}
		
		List<String> ageList=json.getList("data.employee_age");
		List<Integer> ageIntL=new ArrayList<>();
		for(String w:ageList) {
			ageIntL.add(Integer.valueOf(w));
		}
		Collections.sort(ageIntL);
		System.out.println(ageIntL);
		softassert.assertTrue(ageIntL.get(0)==19);
		
		softassert.assertAll();
		
		
			
	}
}
