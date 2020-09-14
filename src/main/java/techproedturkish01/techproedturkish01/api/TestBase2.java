package techproedturkish01.techproedturkish01.api;

import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TestBase2 {

	protected RequestSpecification spec1;
	protected RequestSpecification spec2;
	protected RequestSpecification spec3; 
 	@Before
	public void call1() {
		spec1=new RequestSpecBuilder().
						setBaseUri("https://restful-booker.herokuapp.com/booking").
						build();
		
	}
 	
 	@Before
 	public void call2() {
 		spec2=new RequestSpecBuilder().
 				setBaseUri("http://dummy.restapiexample.com/api/v1/employees").
 				build();
 	}
 	
 	@Before 
 	public void call3() {
 		spec3=new RequestSpecBuilder().
 				setBaseUri("https://jsonplaceholder.typicode.com/todos").
 				build();
 	}
}
