package trials;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import techproedturkish01.techproedturkish01.api.TestBase;

public class Practice2 extends TestBase {

	 /*
	When 
		I send a GET request to REST API URL 
		https://restful-booker.herokuapp.com/booking/1   
   Then 
	    HTTP Status Code should be 200
	    And Response format should be "application/JSON"
	    And first name should be "Sally"
	    And lastname should be "Smith"
	    And totalprice should be 705
	    And checkin date should be "2015-02-16"
	    And checkout date should be "2017-06-20"
	    
	    Note: For Base URL use spec02
	    Note: For actual data use JsonPath
       Note: For expected data use Map
       Note: Use Hard Assertion and Soft Assertion
  */

	@Test
	public void practice2() {
		
//		When 
//		I send a GET request to REST API URL 
//		https://restful-booker.herokuapp.com/booking/1   
//	    Note: For Base URL use spec02
	spec02.pathParam("id", 1);
		Response response=given().spec(spec02).when().get("/{id}");
		response.prettyPrint();
		
//expected
		Map<String,Object> expR=new HashMap<>();
		expR.put("firstname","Mark");
		expR.put("lastname","Jackson");
		expR.put("totalprice",516);
		expR.put("checkin","2018-01-25");
		expR.put("checkout","2018-05-22");
		expR.put("format","application/json; charset=utf-8");
		
		
		//   Then 
//	    HTTP Status Code should be 200
//	    And Response format should be "application/JSON"
		response.then().assertThat().statusCode(200).
		contentType(ContentType.JSON).
				header("Content-Type", Matchers.equalTo(expR.get("format"))).
				body("firstname",  Matchers.equalTo(expR.get("firstname")),
						"lastname", Matchers.equalTo(expR.get("lastname")),
						"totalprice", Matchers.equalTo(expR.get("totalprice")),
						"bookingdates.checkin", Matchers.equalTo(expR.get("checkin")),
						"bookingdates.checkout",Matchers.equalTo(expR.get("checkout")));
//	    And first name should be "Sally"
//	    And lastname should be "Smith"
//	    And totalprice should be 705
//	    And checkin date should be "2015-02-16"
//	    And checkout date should be "2017-06-20"
//	    
		

//	    Note: For actual data use JsonPath
//       Note: For expected data use Map
//       Note: Use Hard Assertion and Soft Assertion
	}
}
