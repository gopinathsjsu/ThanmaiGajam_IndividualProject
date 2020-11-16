package cmpe202.StudentID_014604096.parsers;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import cmpe202.StudentID_014604096.InputDetails;

class JSONParserTest {

	@Test
	void testJSONToObject() {
		try {
		String line ="";
		InputDetails id; //= new CreditCard();
		ObjectMapper mapper = new ObjectMapper();
		BufferedReader br = new BufferedReader(new FileReader("Sample.json"));  
		String jsonString = "";
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
			jsonString+=line + "\n";
		}
		jsonString = "{\r\n"
				+ "  \"cclist\" :"+jsonString+"}";
		//InputStream is = InputDetails.class.getResourceAsStream(fileName);
		
		//System.out.println(is.toString());
		//System.out.println(jsonString);
		id = mapper.readValue(jsonString, InputDetails.class);
		assertNotNull(id);
		}
		catch(Exception e)
		{
			
		}
	}

}
