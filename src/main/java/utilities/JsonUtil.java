package utilities;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

	private static ObjectMapper mapper;
	
	static {
		mapper=new ObjectMapper();
	}
	
	//Let's create a method to convert Java Object to Json (Serialization)
	
	public static String convertJavaToJson (Object obj) {
		String jsonResult="";
		
		try {
		
		jsonResult=mapper.writeValueAsString(obj);
		}catch (JsonGenerationException e) {
			System.out.println("Exception occured while serilization"+e.getMessage());
		} catch (JsonMappingException e) {
			System.out.println("Exception occured while serilization"+e.getMessage());

		} catch (IOException e) {

			System.out.println("Exception occured while serilization"+e.getMessage());
		}
		
		return jsonResult;
		}
	
	//Let's create a method to convert Json to Json Object (De-Serialization)
	//Generic Method : The Method whose return type is selected when you use it
	
	public static <T> T convertJsonToJava(String json, Class<T> cls) {
		
		T javaResult=null;
	
		try {
			javaResult = mapper.readValue(json, cls);
		}catch (JsonGenerationException e) {
			System.out.println("Exception occured while serilization"+e.getMessage());
		} catch (JsonMappingException e) {
			System.out.println("Exception occured while serilization"+e.getMessage());

		} catch (IOException e) {

			System.out.println("Exception occured while serilization"+e.getMessage());
		}
		
		return javaResult;
	}
	
}
