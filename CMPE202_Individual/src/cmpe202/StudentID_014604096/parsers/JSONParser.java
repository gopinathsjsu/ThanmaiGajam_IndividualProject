package cmpe202.StudentID_014604096.parsers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import cmpe202.StudentID_014604096.CardDetails;
import cmpe202.StudentID_014604096.CreditCard;
import cmpe202.StudentID_014604096.InputDetails;
import cmpe202.StudentID_014604096.validation.AmexValidator;
import cmpe202.StudentID_014604096.validation.DiscoverValidator;
import cmpe202.StudentID_014604096.validation.MasterValidator;
import cmpe202.StudentID_014604096.validation.Validator;
import cmpe202.StudentID_014604096.validation.VisaValidator;

public class JSONParser extends FileParser{

	@Override
	public List<CardDetails> parseFile(String fileName) {
		List<CardDetails> listCC = new ArrayList<CardDetails>();
		try {
			String line ="";
			InputDetails id; //= new CreditCard();
			ObjectMapper mapper = new ObjectMapper();
			BufferedReader br = new BufferedReader(new FileReader(fileName));  
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
			//System.out.println(id);
			
//			 try {
//
//			        //File file = new File("C:\\file.xml");
//			        JAXBContext jaxbContext = JAXBContext.newInstance(InputDetails.class);
//			        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//			        // output pretty printed
//			        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//			        //jaxbMarshaller.marshal(customer, file);
//			        jaxbMarshaller.marshal(id, System.out);
//
//			          } catch (JAXBException e) {
//			        e.printStackTrace();
//			          }
			for(CreditCard cc: id.getCclist())
			{
				
				Validator visaHandler = new VisaValidator();
				Validator masterHandler = new MasterValidator();
				Validator amexHandler = new AmexValidator();
				Validator discoverHandler = new DiscoverValidator();
				
				visaHandler.nextHandler(masterHandler);
				masterHandler.nextHandler(amexHandler);
				amexHandler.nextHandler(discoverHandler);
				CreditCard cc1;
				cc1 = visaHandler.validate(cc.getCardNumber());
				CardDetails cd = new CardDetails();
				cd.setCardNumber(cc.getCardNumber());
				if(cc1==null) {
					cd.setCardType("");
					cd.setIsError("Error");
				}else {
					cd.setCardType(cc1.getCardType());
					cd.setIsError("No Error");
				}
				
				listCC.add(cd);		
			}
			return listCC;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return null;
	}

	

}
